package com.wego.web.brd;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Lazy
@Data
@Component 
@AllArgsConstructor
@NoArgsConstructor
public class Community {
	private String artseq, img, uid, comments, msg,
				rating, boardtype, title, content ;
}
