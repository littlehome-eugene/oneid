/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kr.hyundai.oneid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.context.annotation.Profile;

// tag::class[]
@EnableJdbcHttpSession // <1>
public class HttpSessionConfig {

	// tag::cookie-serializer[]
	// @Bean
  // @Profile("develop")
	// public CookieSerializer cookieSerializer2() {
	// 	DefaultCookieSerializer serializer = new DefaultCookieSerializer();
  //   serializer.setDomainName(".zibann.kr");

	// 	// serializer.setDomainNamePattern("^.+?(\\.\\w+\\.[a-z]+)$"); // <3>
	// 	return serializer;
	// }
	// end::cookie-serializer[]

	@Bean
  @Profile("production")
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
    // serializer.setDomainName(".hpay.kr");
    serializer.setDomainName("zibann.kr");

    System.out.println("aaa");
		// serializer.setDomainNamePattern("^.+?(\\.\\w+\\.[a-z]+)$"); // <3>
		return serializer;
	}
	// end::cookie-serializer[]

}
// end::class[]


// tag::class[]

// @Profile("production")
// public class HttpSessionConfig {

// 	// tag::cookie-serializer[]

// }
// end::class[]
