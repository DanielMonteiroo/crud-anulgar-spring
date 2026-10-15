package com.daniel.crud_spring.exception;

public class RecordNotfoundException extends RuntimeException {
     
      private static final long serialVersionUID = 1L;
      
      public RecordNotfoundException(Long id ) {
          super("Registro não encontrado com o ID: " + id);

    }

}
