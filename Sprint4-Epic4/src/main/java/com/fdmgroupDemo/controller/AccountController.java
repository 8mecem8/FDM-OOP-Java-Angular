package com.fdmgroupDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroupDemo.model.Account;
import com.fdmgroupDemo.model.AccountDTO;
import com.fdmgroupDemo.service.AccountService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/account")
@Tag(name = "Account Management", description = "Operations pertaining to accounts related to customers in the bank")
public class AccountController 
{
	AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {super();this.accountService = accountService;}
	
	@GetMapping()
	@Operation(summary = "Get all accounts")
	public List<Account> getAllAccounts()	{return accountService.getAllAccountsList();}
	
	@GetMapping("/by-city")
    public ResponseEntity<List<Account>> getAccountsByCity(@RequestParam String city) {
        List<Account> accounts = accountService.getAccountsByCustomerCity(city);
        return ResponseEntity.ok(accounts);
    }
	
	
	@PostMapping
	@Operation(summary = "Create a new account")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created the account"),@ApiResponse(responseCode = "400", description = "Invalid input")})
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountRequest) 
	{
		System.out.println(accountRequest + " " + "accountRequest");
		Account newAccount = accountService.createAccount(accountRequest);
	    return ResponseEntity.ok(newAccount);
	}
	
	@DeleteMapping("/{id}")
    @Operation(summary = "Delete an account")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully delete the account"), @ApiResponse(responseCode = "404", description = "Account not found")})
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id) 
    {
		accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}
