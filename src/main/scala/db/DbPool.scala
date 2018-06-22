package db

import java.sql.Connection

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

/**
  * Created by Peerapat A on Jun 22, 2017
  */
case class DbPool(config: String = "hikari.properties") {

  private val ds = new HikariDataSource(new HikariConfig(config))

  def get: Connection = ds.getConnection

}
