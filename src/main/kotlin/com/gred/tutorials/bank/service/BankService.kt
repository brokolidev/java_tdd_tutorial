package com.gred.tutorials.bank.service

import com.gred.tutorials.bank.datasource.BankDataSource
import com.gred.tutorials.bank.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank =
        dataSource.retrieveBank(accountNumber)
}