package com.wf.trans.test.rpc;

import com.wf.base.rpc.ChannelRpcService;
import com.wf.base.rpc.dto.ChannelInfoDto;
import com.wf.base.rpc.dto.PageDto;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChannelTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:dubbo-consumer.xml"});
        context.start();
        ChannelRpcService channelRpcService = (ChannelRpcService) context.getBean("channelRpcService");
        PageDto<ChannelInfoDto> dto = new PageDto(new ChannelInfoDto(),0L,20L);
        dto.getP().setName("爱彩");
        System.out.println("find:" + channelRpcService.find(dto));
    }
}
