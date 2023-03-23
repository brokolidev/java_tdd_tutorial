package com.gred.tutorials.bank.datasource.mock

import com.gred.tutorials.bank.datasource.BankDataSource
import com.gred.tutorials.bank.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf(
        Bank("1234", 3.1, 117),
        Bank("1001", 4.1, 0),
        Bank("4123", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("${accountNumber}에 해당하는 Bank를 찾을 수 없습니다.")

}