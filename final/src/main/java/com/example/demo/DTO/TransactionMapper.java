//package com.example.demo.DTO;
//
//import com.example.demo.entities.Transaction;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Mapper(componentModel = "spring")
//public interface TransactionMapper {
//
//    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
//    TransactionDto toDto(Transaction transaction);
//    Transaction fromDto(TransactionDto transactionDto);
//    List<TransactionDto> toDtoList(List<Transaction> transactions);
//    List<Transaction> fromDtoList(List<TransactionDto> transactionDtos);
//}