package com.gred.tutorials.bank.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import javax.print.attribute.standard.Media

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    val baseUrl = "/api/banks"

    @Nested
    @DisplayName("Bank 컬렉션 가져오기")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetBanks {
        @Test
        fun `should return all banks`() {
            // when/then
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountNumber") { value("1234") }
                }
        }
    }

    @Nested
    @DisplayName("단일 Bank 가져오기")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetBank {
        @Test
        fun `should return the bank with the given account number`() {
            // given
            val accountNumber = 1234

            // when / then
            mockMvc.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") { value("3.1") }
                    jsonPath("$.transactionFee") { value("117") }
                }
        }

        @Test
        @DisplayName("잘못된 accountNumber에 대한 처리 확인")
        fun `should return Not Found if the account number does not exist`() {
            // given
            var accountNumber: String = "account_number_not_exist"


            // when / then
            mockMvc.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }

        }
    }



}