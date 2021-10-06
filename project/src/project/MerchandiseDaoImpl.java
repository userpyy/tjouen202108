package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MerchandiseDaoImpl implements DaoMerchadise {
	private static MerchandiseDaoImpl instance = new MerchandiseDaoImpl();

	private MerchandiseDaoImpl() {
	}

	public static MerchandiseDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int insert(DtoMerchandise merchandise) throws ClassNotFoundException, SQLException {
		// id,category,name,quantity,price,expiration_date
		String sql = "insert into merchandise value(?,?,?,?,?,?)";
		try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, merchandise.getId());
			pst.setString(2, merchandise.getCategory());
			pst.setString(3, merchandise.getName());
			pst.setInt(4, merchandise.getQuantity());
			pst.setInt(5, merchandise.getPrice());
			pst.setString(6, merchandise.getExpiration_date().toString());

			return pst.executeUpdate();
		}
	}

	@Override
	public DtoMerchandise merchandiseFindById(int id) throws ClassNotFoundException, SQLException {
		// id,category,name,quantity,price,expiration_date
		String sql = "select * from store where id =?";
		try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				DtoMerchandise merchandise = null;
				if (rs.next()) {
					merchandise = convertMer(rs);
				}
				return merchandise;
			}
		}
	}

	@Override
	public List<DtoMerchandise> merchandiseFindAll() throws ClassNotFoundException, SQLException {
		// id,category,name,quantity,price,expiration_date
		String sql = "select * from store";
		try (Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			List<DtoMerchandise> merList = new ArrayList<DtoMerchandise>();

			while (rs.next()) {
				merList.add(convertMer(rs));
			}
			return merList;
		}
	}

	@Override
	public List<DtoMerchandise> merchandiseFindByName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from store where name like ?";

		try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, "%" + name + "%");
			try (ResultSet rs = pst.executeQuery()) {
				List<DtoMerchandise> merList = new ArrayList<DtoMerchandise>();

				while (rs.next()) {
					merList.add(convertMer(rs));
				}
				return merList;
			}
		}
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from store where id = ?";

		try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, id);

			return pst.executeUpdate();

		}
	}

	@Override
	public int update(DtoMerchandise merchandise) throws ClassNotFoundException, SQLException {
		// id,category,name,quantity,price,expiration_date
		String sql = "update store set category=?, name=?, quantity=?, price=?, expiration_date=? where id=?";

		try (Connection conn = MyConn.getConn(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, merchandise.getCategory());
			pst.setString(2, merchandise.getName());
			pst.setInt(3, merchandise.getQuantity());
			pst.setInt(4, merchandise.getPrice());
			pst.setString(5, merchandise.getExpiration_date().toString());
			pst.setInt(6, merchandise.getId());
			return pst.executeUpdate();
		}
	}

	private DtoMerchandise convertMer(ResultSet rs) throws SQLException {
		// id,category,name,quantity,price,expiration_date
		return new DtoMerchandise(rs.getInt("id"), rs.getString("category"), rs.getString("name"),
				rs.getInt("quantity"), rs.getInt("price"), rs.getDate("expiration_date").toLocalDate());
	}

	

	@Override //판매현황 -ing
	public List<DtoMerchandise> merchandiseFindsale() throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		return null;
	}

}
