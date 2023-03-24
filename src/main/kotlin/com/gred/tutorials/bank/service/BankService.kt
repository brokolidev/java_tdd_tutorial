package com.gred.tutorials.bank.service

import com.gred.tutorials.bank.datasource.BankDataSource
import com.gred.tutorials.bank.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank =
        dataSource.retrieveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)
    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun removeBank(accountNumber: String): Unit = dataSource.removeBank(accountNumber)
}