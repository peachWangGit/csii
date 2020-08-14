package com.csii.pe.transform.json;

import com.csii.pe.common.util.BeanUtils;
import com.csii.pe.transform.TransformException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.JsonProcessingException;
//import org.codehaus.jackson.map.ObjectMapper;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class JsonObject extends AbstractMultiJsonElement {
	private List<AbstractJsonElement> children;
	protected static final byte[] PREFIX = "{".getBytes();
	protected static final byte[] SUFFIX = "}".getBytes();

	
	
	public JsonObject() {
		this.children = new ArrayList();
	}

	public Object[] getChildren() {
		return this.children.toArray();
	}

	public void addChild(Object child) {
		AbstractJsonElement ele = (AbstractJsonElement) child;

		this.children.add(ele);
		ele.setParent(this);
	}

	protected void formatValue(OutputStream out, Object data, Map context) throws TransformException {
		try {
			if (data == null) {
				out.write(NULL);
				return;
			}
			Map map = null;
			if(data instanceof Map) {
				map = (Map) data;
			}else{
				map = BeanUtils.bean2Map(data);
			}
			out.write(PREFIX);
			int index = 0;
			for (AbstractJsonElement obj : this.children) {
				Object value = null;
				if (obj instanceof AbstractMultiJsonElement) {
					value = map.get(obj.getName());
					if ((value == null) && (((AbstractMultiJsonElement) obj).isMerged()))
						value = map;
				} else {
					value = map.get(obj.getName());
				}
				if ((value == null) && (obj.isSkipNull())) {
					continue;
				}
				if (!(obj.calCondition(map, value))) {
					continue;
				}
				if (index > 0) {
					out.write(COMMA);
				}
				writeName(out, obj);
				obj.format(out, value, map);
				++index;
			}
			out.write(SUFFIX);
		} catch (IOException e) {
			throw new TransformException(e);
		}
	}

	private void writeName(OutputStream out, AbstractJsonElement obj) throws IOException {
		if (obj.getName() != null) {
			out.write(QUOTE);
			String name = (obj.getAlias() != null) ? obj.getAlias() : obj.getName();
			out.write(name.getBytes());
			out.write(QUOTE);
			out.write(COLON);
		}
	}

	protected Object parseValue(Object data, Map context) throws TransformException {
		if (data == null)
			return null;
		try {
			JsonNode node = null;
			if (data instanceof JsonNode) {
				node = (JsonNode) data;
			} else {
				ObjectMapper mapper = new ObjectMapper();
				if (data instanceof String)
					node = mapper.readTree((String) data);
				else if (data instanceof InputStream)
					node = mapper.readTree((InputStream) data);
				else if (data instanceof byte[])
					node = mapper.readTree((byte[]) (byte[]) data);
				else {
					throw new TransformException("data's type is not [JsonNode,String,InputStream,byte[]]");
				}
			}
			if (node == null) {
				throw new TransformException("jsonnode is null");
			}
			Map result = new LinkedHashMap();
			for (AbstractJsonElement obj : this.children) {
				String name = (obj.getAlias() == null) ? obj.getName() : obj.getAlias();
				JsonNode fieldValue = node.get(name);
				Object value = obj.parse(fieldValue, context);
				if ((data == null) && (obj.isSkipNull())) {
					continue;
				}
				if ((obj instanceof AbstractMultiJsonElement) && (((AbstractMultiJsonElement) obj).isMerged())
						&& (value instanceof Map)) {
					result.putAll((Map) value);
				}

				result.put(obj.getName(), value);
			}
			return result;
		} catch (JsonProcessingException e) {
			throw new TransformException(e);
		} catch (IOException e) {
			throw new TransformException(e);
		}
	}
}