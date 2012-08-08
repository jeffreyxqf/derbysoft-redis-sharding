package com.derbysoft.redis.clients.common.servlet

import javax.servlet.http.{HttpServletRequest, HttpServlet, HttpServletResponse}
import com.derbysoft.redis.clients.ShardingRedis

class RedisHostsServlet extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    println("RedisHostsServlet get")
    response.getOutputStream().println(ShardingRedis.hosts);
    response.setStatus(HttpServletResponse.SC_OK);
  }

  override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
    val hosts = request.getParameter("hosts");
    response.getOutputStream().println(ShardingRedis.updateHosts(hosts));
    response.setStatus(HttpServletResponse.SC_OK);
  }

}