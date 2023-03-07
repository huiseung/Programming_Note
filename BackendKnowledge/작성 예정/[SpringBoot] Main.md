# 코드
```java
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

```

# run log
- 시작 그림
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.9)
```

- 프로세스
```
2023-03-07 15:42:14.474  INFO 19640 --- [           main] com.example.MainApplication              : Starting MainApplication using Java 11.0.16.1 on LAPTOP-H12L7AVB with PID 19640 (C:\Users\whtjd\Desktop\Programming_Note\SpringBootCode\StudyMySQLBulk\out\production\classes started by whtjd in C:\Users\whtjd\Desktop\Programming_Note\SpringBootCode\StudyMySQLBulk)
```

- application 파일 설정
```
2023-03-07 15:42:14.481  INFO 19640 --- [           main] com.example.MainApplication              : No active profile set, falling back to 1 default profile: "default"
```

- Spring Data JPA 등록
```
2023-03-07 15:42:17.352  INFO 19640 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2023-03-07 15:42:17.412  INFO 19640 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 13 ms. Found 0 JPA repository interfaces.
```

- 톰캣 서버 가동
```
2023-03-07 15:42:20.323  INFO 19640 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-03-07 15:42:20.348  INFO 19640 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-03-07 15:42:20.349  INFO 19640 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.71]
2023-03-07 15:42:20.637  INFO 19640 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
```

- Servlet 등록
```
2023-03-07 15:42:20.638  INFO 19640 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 5899 ms
```

- Hibernate 등록
```
2023-03-07 15:42:21.004  INFO 19640 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2023-03-07 15:42:21.142  INFO 19640 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.15.Final
2023-03-07 15:42:21.588  INFO 19640 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2023-03-07 15:42:21.673 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration boolean -> org.hibernate.type.BooleanType@5d352de0
2023-03-07 15:42:21.674 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration boolean -> org.hibernate.type.BooleanType@5d352de0
2023-03-07 15:42:21.674 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Boolean -> org.hibernate.type.BooleanType@5d352de0
2023-03-07 15:42:21.675 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration numeric_boolean -> org.hibernate.type.NumericBooleanType@2dfeb141
2023-03-07 15:42:21.677 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration true_false -> org.hibernate.type.TrueFalseType@4e424582
2023-03-07 15:42:21.678 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration yes_no -> org.hibernate.type.YesNoType@4d0cc83e
2023-03-07 15:42:21.680 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration byte -> org.hibernate.type.ByteType@42ed89da
2023-03-07 15:42:21.680 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration byte -> org.hibernate.type.ByteType@42ed89da
2023-03-07 15:42:21.681 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Byte -> org.hibernate.type.ByteType@42ed89da
2023-03-07 15:42:21.683 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration character -> org.hibernate.type.CharacterType@34d480b9
2023-03-07 15:42:21.683 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration char -> org.hibernate.type.CharacterType@34d480b9
2023-03-07 15:42:21.683 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Character -> org.hibernate.type.CharacterType@34d480b9
2023-03-07 15:42:21.685 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration short -> org.hibernate.type.ShortType@1df5c7e3
2023-03-07 15:42:21.686 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration short -> org.hibernate.type.ShortType@1df5c7e3
2023-03-07 15:42:21.686 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Short -> org.hibernate.type.ShortType@1df5c7e3
2023-03-07 15:42:21.688 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration integer -> org.hibernate.type.IntegerType@7c96c85
2023-03-07 15:42:21.689 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration int -> org.hibernate.type.IntegerType@7c96c85
2023-03-07 15:42:21.689 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Integer -> org.hibernate.type.IntegerType@7c96c85
2023-03-07 15:42:21.691 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration long -> org.hibernate.type.LongType@644d1b61
2023-03-07 15:42:21.691 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration long -> org.hibernate.type.LongType@644d1b61
2023-03-07 15:42:21.692 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Long -> org.hibernate.type.LongType@644d1b61
2023-03-07 15:42:21.694 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration float -> org.hibernate.type.FloatType@28e8888d
2023-03-07 15:42:21.694 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration float -> org.hibernate.type.FloatType@28e8888d
2023-03-07 15:42:21.694 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Float -> org.hibernate.type.FloatType@28e8888d
2023-03-07 15:42:21.699 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration double -> org.hibernate.type.DoubleType@10f477e2
2023-03-07 15:42:21.700 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration double -> org.hibernate.type.DoubleType@10f477e2
2023-03-07 15:42:21.700 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Double -> org.hibernate.type.DoubleType@10f477e2
2023-03-07 15:42:21.703 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration big_decimal -> org.hibernate.type.BigDecimalType@6371cf2f
2023-03-07 15:42:21.704 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.math.BigDecimal -> org.hibernate.type.BigDecimalType@6371cf2f
2023-03-07 15:42:21.707 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration big_integer -> org.hibernate.type.BigIntegerType@668cc9a2
2023-03-07 15:42:21.707 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.math.BigInteger -> org.hibernate.type.BigIntegerType@668cc9a2
2023-03-07 15:42:21.709 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration string -> org.hibernate.type.StringType@6467ddc7
2023-03-07 15:42:21.709 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.String -> org.hibernate.type.StringType@6467ddc7
2023-03-07 15:42:21.710 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration nstring -> org.hibernate.type.StringNVarcharType@6cbb175
2023-03-07 15:42:21.711 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration ncharacter -> org.hibernate.type.CharacterNCharType@3b97907c
2023-03-07 15:42:21.714 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration url -> org.hibernate.type.UrlType@61f377d1
2023-03-07 15:42:21.714 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.net.URL -> org.hibernate.type.UrlType@61f377d1
2023-03-07 15:42:21.716 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration Duration -> org.hibernate.type.DurationType@4dad8ec0
2023-03-07 15:42:21.717 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.Duration -> org.hibernate.type.DurationType@4dad8ec0
2023-03-07 15:42:21.720 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration Instant -> org.hibernate.type.InstantType@77b5148c
2023-03-07 15:42:21.721 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.Instant -> org.hibernate.type.InstantType@77b5148c
2023-03-07 15:42:21.724 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration LocalDateTime -> org.hibernate.type.LocalDateTimeType@4b88ca8e
2023-03-07 15:42:21.724 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.LocalDateTime -> org.hibernate.type.LocalDateTimeType@4b88ca8e
2023-03-07 15:42:21.727 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration LocalDate -> org.hibernate.type.LocalDateType@30a7653e
2023-03-07 15:42:21.728 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.LocalDate -> org.hibernate.type.LocalDateType@30a7653e
2023-03-07 15:42:21.730 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration LocalTime -> org.hibernate.type.LocalTimeType@2415e4c7
2023-03-07 15:42:21.731 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.LocalTime -> org.hibernate.type.LocalTimeType@2415e4c7
2023-03-07 15:42:21.734 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration OffsetDateTime -> org.hibernate.type.OffsetDateTimeType@4f363abd
2023-03-07 15:42:21.734 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.OffsetDateTime -> org.hibernate.type.OffsetDateTimeType@4f363abd
2023-03-07 15:42:21.737 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration OffsetTime -> org.hibernate.type.OffsetTimeType@6b37df8e
2023-03-07 15:42:21.737 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.OffsetTime -> org.hibernate.type.OffsetTimeType@6b37df8e
2023-03-07 15:42:21.740 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration ZonedDateTime -> org.hibernate.type.ZonedDateTimeType@4665428b
2023-03-07 15:42:21.740 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.time.ZonedDateTime -> org.hibernate.type.ZonedDateTimeType@4665428b
2023-03-07 15:42:21.744 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration date -> org.hibernate.type.DateType@1310fcb0
2023-03-07 15:42:21.744 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.sql.Date -> org.hibernate.type.DateType@1310fcb0
2023-03-07 15:42:21.747 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration time -> org.hibernate.type.TimeType@2fe2965c
2023-03-07 15:42:21.747 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.sql.Time -> org.hibernate.type.TimeType@2fe2965c
2023-03-07 15:42:21.749 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration timestamp -> org.hibernate.type.TimestampType@724bf25f
2023-03-07 15:42:21.750 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.sql.Timestamp -> org.hibernate.type.TimestampType@724bf25f
2023-03-07 15:42:21.750 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.Date -> org.hibernate.type.TimestampType@724bf25f
2023-03-07 15:42:21.753 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration dbtimestamp -> org.hibernate.type.DbTimestampType@29f3c438
2023-03-07 15:42:21.755 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration calendar -> org.hibernate.type.CalendarType@1c046c92
2023-03-07 15:42:21.755 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.Calendar -> org.hibernate.type.CalendarType@1c046c92
2023-03-07 15:42:21.756 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.GregorianCalendar -> org.hibernate.type.CalendarType@1c046c92
2023-03-07 15:42:21.757 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration calendar_date -> org.hibernate.type.CalendarDateType@153cb763
2023-03-07 15:42:21.760 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration calendar_time -> org.hibernate.type.CalendarTimeType@7a83ccd2
2023-03-07 15:42:21.762 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration locale -> org.hibernate.type.LocaleType@256a0d95
2023-03-07 15:42:21.762 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.Locale -> org.hibernate.type.LocaleType@256a0d95
2023-03-07 15:42:21.765 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration currency -> org.hibernate.type.CurrencyType@43d65a81
2023-03-07 15:42:21.765 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.Currency -> org.hibernate.type.CurrencyType@43d65a81
2023-03-07 15:42:21.767 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration timezone -> org.hibernate.type.TimeZoneType@51cab489
2023-03-07 15:42:21.767 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.TimeZone -> org.hibernate.type.TimeZoneType@51cab489
2023-03-07 15:42:21.769 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration class -> org.hibernate.type.ClassType@626e0c86
2023-03-07 15:42:21.769 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Class -> org.hibernate.type.ClassType@626e0c86
2023-03-07 15:42:21.771 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration uuid-binary -> org.hibernate.type.UUIDBinaryType@4aebee4b
2023-03-07 15:42:21.771 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.util.UUID -> org.hibernate.type.UUIDBinaryType@4aebee4b
2023-03-07 15:42:21.772 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration uuid-char -> org.hibernate.type.UUIDCharType@7cf63b9a
2023-03-07 15:42:21.775 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration binary -> org.hibernate.type.BinaryType@2744dcae
2023-03-07 15:42:21.776 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration byte[] -> org.hibernate.type.BinaryType@2744dcae
2023-03-07 15:42:21.776 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration [B -> org.hibernate.type.BinaryType@2744dcae
2023-03-07 15:42:21.778 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration wrapper-binary -> org.hibernate.type.WrapperBinaryType@33e0c716
2023-03-07 15:42:21.779 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration Byte[] -> org.hibernate.type.WrapperBinaryType@33e0c716
2023-03-07 15:42:21.779 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration [Ljava.lang.Byte; -> org.hibernate.type.WrapperBinaryType@33e0c716
2023-03-07 15:42:21.781 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration row_version -> org.hibernate.type.RowVersionType@4fa86cb8
2023-03-07 15:42:21.782 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration image -> org.hibernate.type.ImageType@12952aff
2023-03-07 15:42:21.784 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration characters -> org.hibernate.type.CharArrayType@7f5614f9
2023-03-07 15:42:21.784 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration char[] -> org.hibernate.type.CharArrayType@7f5614f9
2023-03-07 15:42:21.784 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration [C -> org.hibernate.type.CharArrayType@7f5614f9
2023-03-07 15:42:21.786 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration wrapper-characters -> org.hibernate.type.CharacterArrayType@2de9ca6
2023-03-07 15:42:21.787 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration [Ljava.lang.Character; -> org.hibernate.type.CharacterArrayType@2de9ca6
2023-03-07 15:42:21.787 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration Character[] -> org.hibernate.type.CharacterArrayType@2de9ca6
2023-03-07 15:42:21.788 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration text -> org.hibernate.type.TextType@71a4f441
2023-03-07 15:42:21.789 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration ntext -> org.hibernate.type.NTextType@c4d2c44
2023-03-07 15:42:21.796 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration blob -> org.hibernate.type.BlobType@5c48b72c
2023-03-07 15:42:21.797 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.sql.Blob -> org.hibernate.type.BlobType@5c48b72c
2023-03-07 15:42:21.798 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration materialized_blob -> org.hibernate.type.MaterializedBlobType@7ce29a2d
2023-03-07 15:42:21.802 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration clob -> org.hibernate.type.ClobType@781aff8b
2023-03-07 15:42:21.803 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.sql.Clob -> org.hibernate.type.ClobType@781aff8b
2023-03-07 15:42:21.810 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration nclob -> org.hibernate.type.NClobType@58278366
2023-03-07 15:42:21.811 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.sql.NClob -> org.hibernate.type.NClobType@58278366
2023-03-07 15:42:21.813 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration materialized_clob -> org.hibernate.type.MaterializedClobType@552fee7a
2023-03-07 15:42:21.814 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration materialized_nclob -> org.hibernate.type.MaterializedNClobType@475f5672
2023-03-07 15:42:21.816 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration serializable -> org.hibernate.type.SerializableType@2db15f70
2023-03-07 15:42:21.835 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration object -> org.hibernate.type.ObjectType@7fe8c7db
2023-03-07 15:42:21.837 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration java.lang.Object -> org.hibernate.type.ObjectType@7fe8c7db
2023-03-07 15:42:21.839 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_date -> org.hibernate.type.AdaptedImmutableType@7db40fd5
2023-03-07 15:42:21.841 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_time -> org.hibernate.type.AdaptedImmutableType@5e1a5f
2023-03-07 15:42:21.841 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_timestamp -> org.hibernate.type.AdaptedImmutableType@31b0f02
2023-03-07 15:42:21.841 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_dbtimestamp -> org.hibernate.type.AdaptedImmutableType@19ae2ee5
2023-03-07 15:42:21.843 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_calendar -> org.hibernate.type.AdaptedImmutableType@44b940a2
2023-03-07 15:42:21.844 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_calendar_date -> org.hibernate.type.AdaptedImmutableType@34c53688
2023-03-07 15:42:21.845 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_binary -> org.hibernate.type.AdaptedImmutableType@6ffd4c0d
2023-03-07 15:42:21.846 DEBUG 19640 --- [           main] org.hibernate.type.BasicTypeRegistry     : Adding type registration imm_serializable -> org.hibernate.type.AdaptedImmutableType@74c9e11
```

- HikariCP 설정 등록
```
2023-03-07 15:42:22.052  INFO 19640 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-03-07 15:42:22.931  INFO 19640 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-03-07 15:42:23.005  INFO 19640 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
2023-03-07 15:42:23.097 DEBUG 19640 --- [           main] o.h.type.spi.TypeConfiguration$Scope     : Scoping TypeConfiguration [org.hibernate.type.spi.TypeConfiguration@5e0f2c82] to MetadataBuildingContext [org.hibernate.boot.internal.MetadataBuildingContextRootImpl@98637a2]
2023-03-07 15:42:23.498 DEBUG 19640 --- [           main] o.h.type.spi.TypeConfiguration$Scope     : Scoping TypeConfiguration [org.hibernate.type.spi.TypeConfiguration@5e0f2c82] to SessionFactoryImpl [org.hibernate.internal.SessionFactoryImpl@432c0f1]
2023-03-07 15:42:23.594  INFO 19640 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2023-03-07 15:42:23.620 TRACE 19640 --- [           main] o.h.type.spi.TypeConfiguration$Scope     : Handling #sessionFactoryCreated from [org.hibernate.internal.SessionFactoryImpl@432c0f1] for TypeConfiguration
2023-03-07 15:42:23.625  INFO 19640 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
```

- Spring Application 동작 
```
2023-03-07 15:42:24.444  INFO 19640 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-03-07 15:42:24.461  INFO 19640 --- [           main] com.example.MainApplication              : Started MainApplication in 11.474 seconds (JVM running for 12.782)
```