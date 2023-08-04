FROM eclipse-temurin:19-jre-alpine
RUN addgroup -S patientops && adduser -S patientopsapp -G patientops
RUN mkdir -p /opt/app && chown -R patientopsapp:patientops /opt/app
COPY --chown=patientopsapp:patientops target/patient-container.jar /opt/app/patient-container.jar
USER patientopsapp
ENTRYPOINT ["java", "-XX:+UseZGC",  "-Xss1024k", \
            "-XX:ParallelGCThreads=100", "-XX:ConcGCThreads=25",  "-XX:TieredStopAtLevel=1", \
            "-XX:SoftRefLRUPolicyMSPerMB=0","-XX:ZCollectionInterval=30", "-XX:ZFragmentationLimit=10", \
            "-XX:MaxGCPauseMillis=5", "-XX:+UseCompressedClassPointers", "-XX:-UseCompressedOops", "-XX:ZUncommitDelay=30", \
            "-XX:InitiatingHeapOccupancyPercent=35", "-XX:G1HeapRegionSize=16M", \
            "-XX:MinMetaspaceFreeRatio=50", "-XX:MaxMetaspaceFreeRatio=100", \
            "-XX:+UnlockExperimentalVMOptions", "-XshowSettings:vm", "-XX:+PrintFlagsFinal", "-XshowSettings:vm" ,"-XX:MaxRAMPercentage=70", "-XX:OnOutOfMemoryError='kill -9 %p'", "-jar","/opt/app/patient-container.jar"]
EXPOSE 8080