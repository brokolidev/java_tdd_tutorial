package com.gred.tutorials.bank.datasource

import com.gred.tutorials.bank.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
}