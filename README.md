Caso de uso
-----------
1.Dada la colección pagos (payments) se deses conocer
  por prestamo (loanId) el total de pagos realizados
  suma(valuePaid).


2.Cada vez que se realice un pago (payment) se desea que el valor
  ingresado de pago(valuePaid) actualice el saldo actual (currentBalance)
  de la colección loans correspondiente al loanId registrado en la colección payments.
  Nota: Se debe verificar que antes de actualizar el currentBalance el valuePaid
        no supere el valor del préstamo (amountLoaned):
        (loanCancelled = false) and (currentBalance < amountLoaned)  
        
    

 
   
