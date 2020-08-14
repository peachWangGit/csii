package com.csii.demo.usr.api;

import com.csii.demo.usr.dto.TestRequest;
import com.csii.demo.usr.dto.TestResponse;

public interface TestService {
	TestResponse test(TestRequest testRequest);
}
