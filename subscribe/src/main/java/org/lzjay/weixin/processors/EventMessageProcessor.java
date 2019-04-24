package org.lzjay.weixin.processors;

import org.lzjay.weixin.domain.event.EventInMessage;

public interface EventMessageProcessor {

	void onMessage(EventInMessage msg);
}
