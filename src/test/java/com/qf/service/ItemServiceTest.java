package com.qf.service;

import com.qf.AcTests;
import com.qf.pojo.Item;
import com.qf.util.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class ItemServiceTest extends AcTests {

    @Autowired
    private ItemService itemService;

    @Test
    public void findItemByNameLikeAndLimit() {
        PageInfo<Item> pageInfo = itemService.findItemByNameLikeAndLimit(null, 1, 10);

        System.out.println(pageInfo);

        for (Item item : pageInfo.getList()) {
            System.out.println(item);
        }
    }

    @Test
    public void save(){
        Item item = new Item();
        item.setName("xxxx");
        item.setPrice(new BigDecimal(1.1));
        item.setProductionDate(new Date());
        item.setDescription("yyyyyyyyyyyyy");
        item.setPic("zzzzzzzzzzzz");

        Integer count = itemService.save(item);

        assertEquals(new Integer(1),count);
    }

    @Test
    @Transactional
    public void del(){
        Integer count = itemService.del(14L);

        Assert.assertEquals(new Integer(1),count);
    }

}