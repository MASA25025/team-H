package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
//	クラス変数　全体で1つだけ、共有データとして保持
	static DataSource ds;

	public Connection getConnection() throws Exception{
//		最初の１回だけ実行したい
		if(ds == null){

//		データベースに接続
//			aaaa
		InitialContext ic=new InitialContext();
		ds =(DataSource)ic.lookup(
				"java:/comp/env/jdbc/Javasd");
		}

		return ds.getConnection();
	}
}

