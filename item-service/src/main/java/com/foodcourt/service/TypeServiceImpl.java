package com.foodcourt.service;

import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public List <ItemTypes> getAllTypes(Integer cid)
	{
		List<ItemTypes> types= new ArrayList<>();
		typeRepository.findByCategoryId(cid).forEach(types :: add);
		return types;
	}
	
	@Override
	public Optional<ItemTypes> getItemTypes(Integer id)
	{
		return typeRepository.findById(id);
	}
	
	@Override
	public void saveType(ItemTypes itemTypes)
	{
		typeRepository.save(itemTypes);
	}
	
	 
	@Override
	public void updateType(ItemTypes itemTypes)
	{
		typeRepository.save(itemTypes);
	}
	
	@Override
	public void deleteType(Integer id)
	{
		typeRepository.deleteById(id);
	}
	
	
	

}
