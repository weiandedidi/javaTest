package md5;

import com.alibaba.fastjson.JSON;
import com.sankuai.shangou.empower.uwm.scheduler.brain.dto.HardWareStateInfoDTO;
import com.sankuai.shangou.empower.uwm.scheduler.brain.dto.TaskStateInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author qidi
 * @date 2019-12-17 14:24
 */
public class TestMd5 {
    public static void main(String[] args) {
        String str_task_1 = "{\"taskId\":108190,\"status\":1,\"skuInfos\":[{\"count\":1,\"skuId\":4063},{\"count\":1,\"skuId\":4052},{\"count\":1,\"skuId\":4064},{\"count\":1,\"skuId\":4020},{\"count\":2,\"skuId\":4022},{\"count\":2,\"skuId\":4013},{\"count\":1,\"skuId\":4002},{\"count\":1,\"skuId\":4047},{\"count\":1,\"skuId\":4025},{\"count\":1,\"skuId\":4026},{\"count\":2,\"skuId\":4048}],\"wmOrderId\":\"26969622872210969\",\"cTime\":1576562812,\"orderId\":\"8984\"}";
        String str_task_2 = "{\"taskId\":108200,\"status\":1,\"skuInfos\":[{\"count\":1,\"skuId\":4007}],\"wmOrderId\":\"26969621450059779\",\"cTime\":1576562817,\"orderId\":\"8994\"}";

        List<TaskStateInfoDTO> taskStateInfoDTOList = Lists.newArrayList();
        TaskStateInfoDTO task_1 = JSON.parseObject(str_task_1, TaskStateInfoDTO.class);
        TaskStateInfoDTO task_2 = JSON.parseObject(str_task_2, TaskStateInfoDTO.class);
        taskStateInfoDTOList.add(task_1);
        taskStateInfoDTOList.add(task_2);

        //硬件
        String str_device_1 = "{\"coordinateX\":1,\"coordinateY\":4,\"id\":861,\"full\":0,\"capacity\":2,\"htypeName\":\"取货仓\",\"taskId\":108186,\"status\":1,\"coodY\":9000,\"coodX\":2500,\"skuList\":[{\"count\":1,\"skuId\":4019},{\"count\":1,\"skuId\":4001}],\"warehouseId\":1000792,\"warehouseDeviceId\":26,\"htype\":1,\"actionId\":1565878374,\"statusDesc\":\"空闲\"}";
        String str_device_2 = "{\"coordinateX\":5000,\"coordinateY\":2500,\"id\":1572085881,\"full\":0,\"capacity\":6,\"targetType\":4,\"htypeName\":\"小车\",\"taskId\":108181,\"status\":4,\"coodY\":2500,\"coodX\":5000,\"skuList\":[{\"count\":1,\"skuId\":4051}],\"targetId\":1572085831,\"warehouseId\":1000792,\"warehouseDeviceId\":91,\"htype\":3,\"actionId\":1565878330,\"statusDesc\":\"待命，本task可调用，其他task不可用（小车到货柜等待，取货仓、暂存仓未清空这些状态）\"}";

        HardWareStateInfoDTO device1 = buildDevice(str_device_1);
        HardWareStateInfoDTO device2 = buildDevice(str_device_2);
        List<HardWareStateInfoDTO> hardWareStateInfoDTOS = Lists.newArrayList();
        hardWareStateInfoDTOS.add(device1);
        hardWareStateInfoDTOS.add(device2);


        Repository repository1 = Repository.buildRepository(device1, device2, task_1, task_2);
        String one = repository1.toString();
        System.out.println(Repository.md5Key(repository1.toString()));


        HardWareStateInfoDTO device2_1 = buildDevice(str_device_1);
        HardWareStateInfoDTO device2_2 = buildDevice(str_device_2);
        device2_1.setCtime(1234567890L);
        Repository repository2 = Repository.buildRepository(device2_1, device2_2, task_1, task_2);
        String two = repository2.toString();
        System.out.println(Repository.md5Key(repository2.toString()));


        HardWareStateInfoDTO device3_1 = buildDevice(str_device_1);
        HardWareStateInfoDTO device3_2 = buildDevice(str_device_2);
        device3_1.setCtime(1234567890L);
        Repository repository3 = Repository.buildRepository(device3_1, device3_2, task_1, task_2);
        String three = repository3.toString();
        System.out.println(Repository.md5Key(repository3.toString()));

        HardWareStateInfoDTO device4_1 = buildDevice(str_device_1);
        HardWareStateInfoDTO device4_2 = buildDevice(str_device_2);
        device3_1.setCtime(1234567890L);
        Repository repository4 = Repository.buildRepository(device4_1, device4_2, task_1, task_2);
        String four = repository4.toString();

        System.out.println(Repository.md5Key(repository4.toString()));


        device1 = JSON.parseObject(str_device_1, HardWareStateInfoDTO.class);
        Repository repository5 = Repository.buildRepository(device1, device2, task_1, task_2);
        String five = repository5.toString();
        System.out.println(Repository.md5Key(repository5.toString()));


        System.out.println(one.equalsIgnoreCase(two));
        System.out.println(three.equalsIgnoreCase(two));
        System.out.println(three.equalsIgnoreCase(four));
        System.out.println(five.equalsIgnoreCase(one));

        System.out.println();

        System.out.println(repository1.equals(repository2));
        System.out.println("id" + repository1.getHardWareStateInfoDTOS().get(0).getId());



        System.out.println(repository3.equals(repository2));
        System.out.println(repository3.equals(repository4));
        System.out.println(repository5.equals(repository1));

    }

    private static HardWareStateInfoDTO buildDevice(String str_device_1) {
        return JSON.parseObject(str_device_1, HardWareStateInfoDTO.class);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Repository {
        /**
         * md5唯一key
         */
        List<TaskStateInfoDTO> taskStateInfoDTOS;
        List<HardWareStateInfoDTO> hardWareStateInfoDTOS;

        //库存

        //management

        //cache 所有的东西

        //management中的status

        public static Repository buildRepository(HardWareStateInfoDTO hardWareStateInfoDTO1, HardWareStateInfoDTO hardWareStateInfoDTO2, TaskStateInfoDTO taskStateInfoDTO1, TaskStateInfoDTO taskStateInfoDTO2) {
            List<TaskStateInfoDTO> taskStateInfoDTOS = Lists.newArrayList();
            taskStateInfoDTOS.add(taskStateInfoDTO1);
            taskStateInfoDTOS.add(taskStateInfoDTO2);

            List<HardWareStateInfoDTO> hardWareStateInfoDTOS = Lists.newArrayList();
            hardWareStateInfoDTOS.add(hardWareStateInfoDTO1);
            hardWareStateInfoDTOS.add(hardWareStateInfoDTO2);
            return new Repository(taskStateInfoDTOS, hardWareStateInfoDTOS);
        }

        public static String md5Key(String key) {
            //md5
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(key.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        }
    }
}
