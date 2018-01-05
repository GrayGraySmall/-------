package pet.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pet.model.PetInfo;
import pet.view_model.PetViewInfo;

@Repository
public class PetInfoDao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 更具宠物编号查询宠物
	 * 
	 * @param petId
	 * @return
	 */
	public PetInfo selectById(int petId) {
		System.out.println(petId);
		String sql = "select * from Pet where petId = ?";
		List<PetInfo> pet = jdbcTemplate.query(sql, new Object[] { petId },
				BeanPropertyRowMapper.newInstance(PetInfo.class));
		if(pet != null)
			return pet.get(0);
		return null;
	}

	/**
	 * 用户新增宠物
	 * 
	 * @param pet
	 * @return
	 */
	public int insertPet(PetViewInfo pet) {
		String sql = "insert into Pet(userPhoneNumber,petSex,petName,"
				+ "petBirthday,petKind,petWeight) values(?, ?, ?, ?, ?, ?)";
		int ret = jdbcTemplate.update(sql, new Object[] { pet.getUserPhoneNumber(), pet.getPetSex(), pet.getPetName(),
				pet.getPetBirthday(), pet.getPetKind(), pet.getPetWeight() });
		return ret;
	}
	
	/**
	 * 根据用户查看用户所拥有的宠物
	 * @param UserTel
	 * @return
	 */
	public PetInfo[] selectPetByUserTel(String UserTel) {
		String sql = "select * from dbo.Pet where userPhoneNumber = ?";
		List<PetInfo> pets = jdbcTemplate.query(sql, new Object[]{UserTel}, BeanPropertyRowMapper.newInstance(PetInfo.class));
		return pets.toArray(new PetInfo[0]);
	}
}
