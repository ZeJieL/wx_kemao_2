package org.lzjay.weixin;

import java.util.Date;

import javax.transaction.Transactional;

import org.lzjay.weixin.domain.User;
import org.lzjay.weixin.domain.event.EventInMessage;
import org.lzjay.weixin.processors.EventMessageProcessor;
import org.lzjay.weixin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("unsubscribeMessageProcessor")
public class UnsubscribeEventMessageProcessor implements EventMessageProcessor {

	@Autowired
	private UserRepository userRepository;

	@Override
	// 表示方法要有事务，在事务内调用数据库查询到的对象的set方法，会自动更新到数据库
	@Transactional
	public void onMessage(EventInMessage msg) {
		if (msg.getEvent().equals("unsubscribe")) {
			System.out.println("取消关注消息处理器: " + msg);
			// 1.解除用户的关注状态
			User user = this.userRepository.findByOpenId(msg.getFromUserName());
			// 一般不删除数据，而是把数据标记为已经取消关注
			if (user != null) {
				user.setStatus(User.Status.IS_UNSUBSCRIBE);
				user.setUnsubTime(new Date());
			}
		}
	}
}
