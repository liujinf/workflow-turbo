package com.xiaoju.uemc.turbo.engine.engine;

import com.xiaoju.uemc.turbo.engine.dto.CreateFlowDTO;
import com.xiaoju.uemc.turbo.engine.dto.DeployFlowDTO;
import com.xiaoju.uemc.turbo.engine.dto.FlowModuleDTO;
import com.xiaoju.uemc.turbo.engine.engine.impl.ProcessEngineImpl;
import com.xiaoju.uemc.turbo.engine.param.CreateFlowParam;
import com.xiaoju.uemc.turbo.engine.param.DeployFlowParam;
import com.xiaoju.uemc.turbo.engine.param.UpdateFlowParam;
import com.xiaoju.uemc.turbo.engine.runner.BaseTest;
import com.xiaoju.uemc.turbo.engine.util.EntityBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by Stefanie on 2019/12/3.
 */
public class ProcessEngineTest extends BaseTest {

    @Autowired
    ProcessEngine processEngine;

    @Resource
    ProcessEngineImpl processEngineImpl;

    @Test
    public void createFlowTest() {
        CreateFlowParam createFlowParam = EntityBuilder.buildCreateFlowParam();
        try {
            CreateFlowDTO createFlowDTO = processEngineImpl.createFlow(createFlowParam);
            LOGGER.info("flowModuleId={}", createFlowDTO.getFlowModuleId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateFlowTest() {
        UpdateFlowParam updateFlowParam = EntityBuilder.buildUpdateFlowParam();
        updateFlowParam.setFlowModuleId("a038f993-1d7c-11ea-928e-8214dae31b03");
        try {
            boolean result = processEngineImpl.updateFlow(updateFlowParam);
            LOGGER.info("result={}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFlowModuleTest() {
        String flowModuleId = "a038f993-1d7c-11ea-928e-8214dae31b03";
        try {
            FlowModuleDTO flowModule = processEngineImpl.getFlowModule(flowModuleId);
            LOGGER.info("flowModule={} by flowModuleId", flowModule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deployFlowTest() {
        DeployFlowParam deployFlowParam = new DeployFlowParam("didi", "optimus-prime");
        deployFlowParam.setFlowModuleId("76bb65d9-35ef-11ea-a4cd-5ef9e2914105");
        deployFlowParam.setOperator("didiwangxing");
        try {
            DeployFlowDTO deployFlowDTO = processEngineImpl.deployFlow(deployFlowParam);
            LOGGER.info("deployFlowDTO={}", deployFlowDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}