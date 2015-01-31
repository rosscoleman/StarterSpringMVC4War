/*
   Copyright 2015 Ross A. Coleman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package starterspringmvc4.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = { "/", "/about" }, method = RequestMethod.GET)
	public Map<String, String> about() {
		// TODO: get version and build date from Gradle-generated
		// version.properties file
		Map<String, String> aboutMap = new LinkedHashMap<String, String>();
		aboutMap.put("name", "Starter Spring MVC 4 Project");
		aboutMap.put("version", "0.1-SNAPSHOT");
		aboutMap.put("author", "Ross Coleman");
		aboutMap.put("date", "2015-01-31");
		return aboutMap;
	}

	@RequestMapping(value = "/secured", method = RequestMethod.GET)
	public String securedInfo() {
		return "pretend this is sensitive information that requires authentication";
	}

}
