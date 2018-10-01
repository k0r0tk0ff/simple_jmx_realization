package ru.k0r0tk0ff;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JmxSimpleRealization {
    private static final int DEFAULT_COUNT_OF_THREADS =10;
    private static final String DEFAULT_SCHEMA="default";

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        SystemConfig mBean = new SystemConfig(DEFAULT_COUNT_OF_THREADS, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("ru.k0r0tk0ff:type=SystemConfig");
        mbs.registerMBean(mBean, name);

        do{
            Thread.sleep(3000);
            System.out.println("Thread Count="+mBean.getThreadCount()+":::Schema Name="+mBean.getSchemaName());
        }while(mBean.getThreadCount() !=0);
    }
}
