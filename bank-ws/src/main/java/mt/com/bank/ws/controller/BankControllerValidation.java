package mt.com.bank.ws.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * /**
 * @author Waylon.Mifsud
 * @since 22/10/2015
 *
 * Handles parsing of internal exceptions to return proper error messages.
 */
@ControllerAdvice
public class BankControllerValidation
{
    private static Gson gson = new Gson();

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String processValidationError(MethodArgumentNotValidException ex)
    {
        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();
        return error.getDefaultMessage();
    }

    /**
     * Any runtime exceptions which may be thrown by the application
     * are caught by this method and shown to the user accordingly with an internal server error.
     * @param ex {@link Exception}
     * @return {@link String} the error message.
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public String processValidationError(RuntimeException ex)
    {
        return ex.getClass().getName() + ": " + ex.getMessage();
    }

    /**
     * Any unhandled exception which may be thrown by  the application
     * are caught by this method and shown to the user accordingly with an internal server error.
     * @param ex {@link Exception}
     * @return {@link String} the error message.
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String processValidationError(Exception ex)
    {
        return "Unhandled exception: " +
                ex.getClass().getName() +
                ": " +
                ex.getMessage();
    }

    /**
     * In case the database server is down, the exception is
     * caught by this method and an internal server error status
     * is returned to the client.
     * @param ex {@link CannotCreateTransactionException}
     * @return {@link String} the error message.
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CannotCreateTransactionException.class)
    public String processDatabaseConnectionError(CannotCreateTransactionException ex)
    {
        return "Unable to connect to database: " +
                ex.getClass().getName() +
                ": " +
                ex.getMessage();
    }

    /**
     * This method catches any constraint violations
     * which may be triggered by the database and handled accordingly.
     * @param ex {@link ConstraintViolationException}
     * @return {@link List<String>} errorMessages.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String processConstraintError(ConstraintViolationException ex)
    {
        List<String> errorMessages = new ArrayList<>();
        Set<ConstraintViolation<?>> result = ex.getConstraintViolations();
        for (ConstraintViolation violation : result)
        {
            errorMessages.add(violation.getMessage());
        }
        return gson.toJson(errorMessages);
    }
}
