package com.sungardhe.demo.portlets.bookportlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sungardhe.demo.portlets.bookportlet.util.ConnectionPool;

public class BookItemDAO {

	private static final String _GET_BOOK_ITEM =
		"Select bookItemId, bookTitle, bookPrice from BookItem where bookItemId = ?";
	private static final String _GET_BOOK_ITEMS = 
		"select bookItemId, bookTitle, bookPrice from BookItem order by bookTitle ASC";
	
	public static BookItem getBookItem(long bookItemId) throws SQLException {
		BookItem bookItem = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionPool.getConnection();
			ps = con.prepareStatement(_GET_BOOK_ITEM);
			ps.setLong(1, bookItemId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				bookItem = new BookItem();
				bookItem.setBookItemId(bookItemId);
				bookItem.setTitle(rs.getString(2));
				bookItem.setPrice(rs.getDouble(3));				
			}
		}
		finally {
			ConnectionPool.cleanUp(con, ps, rs);
		}
		
		return bookItem;
	}
	
	public static List<BookItem> getBookItems() throws SQLException {
		List<BookItem> list = new ArrayList<BookItem>();
		
		BookItem bookItem = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionPool.getConnection();
			ps = con.prepareStatement(_GET_BOOK_ITEMS);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				bookItem = new BookItem();
				bookItem.setBookItemId(rs.getLong(1));
				bookItem.setTitle(rs.getString(2));
				bookItem.setPrice(rs.getDouble(3));	
				list.add(bookItem);
			}
		}
		finally {
			ConnectionPool.cleanUp(con, ps, rs);
		}
		
		return list;
	}
}
