package org.lzjay.weixin.processors.impl;

import org.lzjay.weixin.domain.event.EventInMessage;
import org.lzjay.weixin.processors.EventMessageProcessor;
import org.springframework.stereotype.Service;

@Service("unsubscribeMessageProcessor")
public class UnsubscribeEventMessageProcessor implements EventMessageProcessor {

	@Override
	public void onMessage(EventInMessage msg) {
		System.out.println("取消关注消息处理器: " + msg);
		// 1.解除用户的关注状态
		// 一般不删除数据，而是把数据标记为已经取消关注
	}
}
