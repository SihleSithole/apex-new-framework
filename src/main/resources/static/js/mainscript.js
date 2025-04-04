/* VIEW PROFILE */

 function encryptEmail(event, email, hiddenFieldId) {
        // Prevent the form from submitting immediately
        event.preventDefault();

        // Encrypt the email
        const encryptedEmail = simpleEncrypt(email);

        // Set the encrypted email in the hidden input
        document.getElementById(hiddenFieldId).value = encryptedEmail;

        // Now submit the form
        document.getElementById(hiddenFieldId).closest('form').submit();
    }
	
	   function simpleEncrypt(text) {
	    let shift = 3; // You can change this value to shift by more or less
	    let encrypted = '';
	    
	    for (let i = 0; i < text.length; i++) {
	        let char = text.charCodeAt(i);
	        
	        // Shift uppercase letters
	        if (char >= 65 && char <= 90) {
	            char = ((char - 65 + shift) % 26) + 65;
	        }
	        // Shift lowercase letters
	        else if (char >= 97 && char <= 122) {
	            char = ((char - 97 + shift) % 26) + 97;
	        }
	        // Shift numbers
	        else if (char >= 48 && char <= 57) {
	            char = ((char - 48 + shift) % 10) + 48;
	        }
	        
	        encrypted += String.fromCharCode(char);
	    }
	    return encrypted;
	}
	
	/* VIEW PROFILE */