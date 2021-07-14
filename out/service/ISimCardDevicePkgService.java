package com.jlpay.service;

/**
 ** @auther yunteng
 */
public interface SimCardDevicePkgService {
	
	public static String SERVER_NAME="SimCardDevicePkgService";
	/**
	 * 根据主键id查询
	 * @param orderId
	 * @return
	 */
	public SimCardDevicePkg get(String id);
	
	/**
	 * 保存
	 * @param simCardDevicePkg
	 */
	public void save(SimCardDevicePkg simCardDevicePkg);
	
	/**
	 * 修改
	 * @param simCardDevicePkg
	 */
	public void update(SimCardDevicePkg simCardDevicePkg);
}
