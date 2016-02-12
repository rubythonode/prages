package com.prages.ch1.client;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.junit.Test;

import com.prages.base.AbstractBaseClientTest;

/**
 * Created by lks21c on 16. 1. 29.
 */
public class ClientIndexTest extends AbstractBaseClientTest {

    @Test
    public void testDeleteIndex() throws Exception {
        DeleteIndexResponse deleteIndexResponse = indicesAdminClient.prepareDelete("priceinfo").get();
        System.out.println("isAcknowledged = " + deleteIndexResponse.isAcknowledged());
    }


    @Test
    public void testCreateIndex() throws Exception {
        CreateIndexResponse createIndexResponse = indicesAdminClient.prepareCreate("priceinfo")
                .setSettings(resourceFileReadUtil.getFileContent("prages/ch1/schema/price_detail_settings.json"))
                .addMapping("info", resourceFileReadUtil.getFileContent("prages/ch1/schema/price_detail_mappings.json"))
                .get();
        System.out.println("isAcknowledged = " + createIndexResponse.isAcknowledged());
    }

    @Test
    public void testIndex() throws Exception {
    }
}