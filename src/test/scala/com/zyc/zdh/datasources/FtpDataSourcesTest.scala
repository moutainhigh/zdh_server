package com.zyc.zdh.datasources

import com.zyc.TEST_TRAIT2
import org.scalatest.FunSuite

class FtpDataSourcesTest extends FunSuite with TEST_TRAIT2{

  test("testGetDS") {
    import spark.implicits._
    val inputOptions=Map("sep"->"|",
      "url"->"10.136.1.217",
    "paths"->"/app/zyc/zyc.txt",
      "user"->"zyc",
      "password"->"123456",
      "header"->"false"
    )
    val inputCols=Array("name","sex","age")
    val df=SFtpDataSources.getDS(spark,null,"ftp",inputOptions,"",inputCols,null,null,null,null,null)("")
      df.show()
    val options=Map("sep"->",",
      "url"->"10.136.1.217",
      "paths"->"/app/zyc/zyc1.txt",
      "user"->"zyc",
      "password"->"123456",
      "header"->"false"
    )

    SFtpDataSources.writeDS(spark,df,options,"")("")

  }

}
