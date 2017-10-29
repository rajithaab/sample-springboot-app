package com.sample.rest.data.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.rest.data.controller.RestMetaDataFileController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RestMetaDataFileController.class, secure = false)
public class RestMetaDataFileTestController {
	
}
