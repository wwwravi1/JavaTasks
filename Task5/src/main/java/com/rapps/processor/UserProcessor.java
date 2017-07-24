package com.rapps.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rapps.model.UserModel;

@Component("itemProcessor")
@Scope(value = "step")
public class UserProcessor implements ItemProcessor<UserModel, UserModel> {

	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	@Override
	public UserModel process(UserModel item) throws Exception {

		System.out.println(threadName + " processing : " + item.getUserId() + " : " + item.getUserName());

		return item;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
