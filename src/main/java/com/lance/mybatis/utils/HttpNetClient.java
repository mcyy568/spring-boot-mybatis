package com.lance.mybatis.utils;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

@SuppressWarnings({"resource", "deprecation"})
public class HttpNetClient {

	/**
	 * 所有get 请求底层调用方法
	 *
	 * @param url
	 *            请求url
	 * @return String
	 */
	public static String doGet(String url) {
		String bre = null;
		HttpResponse response;
		if (url != null && url.length() != 0) {
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Accept-Encoding", "gzip, deflate");
			httpGet.setHeader("Accept-Language", "zh-CN");
			httpGet.setHeader("Accept", "application/json, application/xml, text/html, text/*, image/*, */*");
			try {
				response = new DefaultHttpClient().execute(httpGet);
				if (response != null) {
					if (response.getStatusLine().getStatusCode() == 200) {
						bre = EntityUtils.toString(response.getEntity());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bre;
	}

	/**
	 * 所有Post 请求底层调用方法
	 *
	 * @param url
	 *            请求url
	 * @param values
	 *            传递的参数
	 * @return byte[] 返回数据 or null
	 */
	public static String doPost(String url, Object values) {
		String obj = JSON.toJSONString(values);
		String bre = null;
		HttpResponse response;
		if (url != null && url.length() != 0) {
			HttpPost post = new HttpPost(url);
			post.setHeader("Accept-Encoding", "gzip, deflate");
			post.setHeader("Accept-Language", "zh-CN");
			post.setHeader("Accept", "application/json, application/xml, text/html, text/*, image/*, */*");
			DefaultHttpClient client = new DefaultHttpClient();
			try {
				if (StringUtils.isNotBlank(obj)) {
					StringEntity entity = new StringEntity(obj, "utf-8");
					entity.setContentEncoding("UTF-8");
					entity.setContentType("application/json");
					post.setEntity(entity);
				}
				response = client.execute(post);
				if (response != null) {
					if (response.getStatusLine().getStatusCode() == 200) {
						bre = EntityUtils.toString(response.getEntity());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bre;
	}

	/**
	 * PUT基础请求
	 *
	 * @param url
	 *            请求地址
	 * @param values
	 *            提交参数
	 * @return byte[] 请求成功后的结果
	 */
	public static String doPut(String url, Object values) {
		String obj = JSON.toJSONString(values);
		String ret = null;
		if (url != null && url.length() > 0) {
			HttpPut request = new HttpPut(url);
			request.setHeader("Accept-Encoding", "gzip, deflate");
			request.setHeader("Accept-Language", "zh-CN");
			request.setHeader("Accept", "application/json, application/xml, text/html, text/*, image/*, */*");
			DefaultHttpClient client = new DefaultHttpClient();
			try {
				if (StringUtils.isNotBlank(obj)) {
	                StringEntity entity = new StringEntity(obj, "utf-8");
	                entity.setContentEncoding("UTF-8");
	                entity.setContentType("application/json");
	                request.setEntity(entity);
	            }
				HttpResponse response = client.execute(request);
				if (response != null) {
					if (response.getStatusLine().getStatusCode() == 200) {
						ret = EntityUtils.toString(response.getEntity());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Delete基础请求
	 *
	 * @param url
	 *            请求地址
	 * @return 请求成功后的结果
	 */
	public static String doDelete(String url) {
		String bre = null;
		HttpResponse response;
		if (url != null && url.length() != 0) {
			HttpDelete delete = new HttpDelete(url);
			delete.setHeader("Accept-Encoding", "gzip, deflate");
			delete.setHeader("Accept-Language", "zh-CN");
			delete.setHeader("Accept", "application/json, application/xml, text/html,text/*, image/*, */*");
			try {
				response = new DefaultHttpClient().execute(delete);
				if (response != null) {
					if (response.getStatusLine().getStatusCode() == 200) {
						bre = EntityUtils.toString(response.getEntity());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bre;
	}

}