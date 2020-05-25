package com.harish.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.demo.model.Article;
import com.harish.demo.model.Blogger;
import com.harish.demo.model.Response;

import io.jsonwebtoken.Jwts;

@RestController
public class BloggerController {

	@RequestMapping("/login")
	public Response login(@RequestBody Blogger blogger) {
		Response response = new Response();
		String jwttoken = "";
		try {
			if (!(blogger.getUsername().isEmpty()
					&& blogger.getPassword().isEmpty())) {
				response.setMessage("success");
				Map<String, Object> claims = new HashMap<String, Object>();
				claims.put("usr", blogger.getUsername());
				jwttoken = Jwts.builder().setClaims(claims).compact();
				System.out.println("Token for the user= " + jwttoken);
				response.setAccessToken(jwttoken);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping("/register")
	public ResponseEntity<String> getEmployees(@RequestBody Blogger blogger) {
		String message = "";
		try {
			if (!(blogger.getUsername().isEmpty() && blogger.getPassword().isEmpty() && blogger.getEmail().isEmpty()
					&& blogger.getAddress().isEmpty())) {
				message = "new user created";
			} else {
				message = "user not created";
				return new ResponseEntity<String>(message, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Exception Occurred";
		}
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@RequestMapping("/articles")
	public ResponseEntity<String> crateArticles(@RequestBody Article article) {
		String message = "";
		String jwttoken = "";
		try {
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("usr", article.getAuthor());

			jwttoken = Jwts.builder().setClaims(claims).compact();
			System.out.println("Token sent from request= " + jwttoken);
			if (!(article.getAuthor().isEmpty()) && jwttoken.equalsIgnoreCase(article.getAccessToken())) {
				message = "new article created";
			} else {
				message = "article not created";
				return new ResponseEntity<String>(message, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Exception Occurred";
		}
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@GetMapping("/articles")
	public List<Article> listArticles() {
		List<Article> articles = new ArrayList<>();
		String[] authors = { "abinash", "suhas", "harish", "mukesh" };
		try {
			for (int n = 1; n < 5; n++) {
				Article article = new Article("modestack-blog-" + n,
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"
								+ "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
								+ "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate"
								+ "velit esse cillum dolore eu fugiat nulla pariatur",
						authors[n - 1]);
				articles.add(article);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
}
