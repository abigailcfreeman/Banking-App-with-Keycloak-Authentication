package com.ironhack.hellokeycloak.model;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long sender;
    private Long receiever;
    private Money amount;
    private String fromAccountName;
    private String toAccountName;

    public static Transaction fromDTO(Long sender, Long receiver, TransactionDTO dto){
        var transactionNew = new Transaction();
        transactionNew.setSender(sender);
        transactionNew.setReceiever(receiver);
        transactionNew.setAmount(dto.getAmount());
        transactionNew.setFromAccountName(dto.getFromAccountName());
        transactionNew.setToAccountName(dto.getToAccountName());
        return transactionNew;
    }

}