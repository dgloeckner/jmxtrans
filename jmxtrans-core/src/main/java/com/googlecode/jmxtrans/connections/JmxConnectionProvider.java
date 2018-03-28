/**
 * The MIT License
 * Copyright © 2010 JmxTrans team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.googlecode.jmxtrans.connections;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnector;
import java.io.IOException;

/**
 * Created by gehel on 29.12.15.
 */
public interface JmxConnectionProvider {
	@JsonIgnore
	JMXConnector getServerConnection() throws IOException;

	@JsonIgnore
	MBeanServer getLocalMBeanServer();

	boolean isLocal();

	/**
	 * Registers notification listeners in the JMX connection
	 * as needed by the queries configured for the server.
	 * @see com.googlecode.jmxtrans.model.Query.QueryType#NOTIFICATIONS
	 *
	 * @param jmxConnection
	 * @throws Exception
	 */
	void subscribeToNotifications(JMXConnection jmxConnection) throws Exception;
}