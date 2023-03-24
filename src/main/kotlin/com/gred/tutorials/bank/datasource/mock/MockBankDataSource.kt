package com.gred.tutorials.bank.datasource.mock

import com.gred.tutorials.bank.datasource.BankDataSource
import com.gred.tutorials.bank.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 3.1, 117),
        Bank("1001", 4.1, 0),
        Bank("4123", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("${accountNumber}에 해당하는 Bank를 찾을 수 없습니다.")

    override fun createBank(bank: Bank): Bank {
        if(banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("${bank.accountNumber}에 해당하는 동일한 Bank가 이미 존재합니다.")
        }
        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw  NoSuchElementException("${bank.accountNumber}에 해당하는 Bank가 없습니다.")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun removeBank(accountNumber: String) {
        val selectedBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("${accountNumber}에 해당하는 Bank를 찾을 수 없습니다.")

        banks.remove(selectedBank)
    }

}