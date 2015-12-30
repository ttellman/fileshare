package com.murtell.fileserver.interfaces;

/**
 * Created by Tim on 12/30/2015.
 */
public interface Commands {

    byte	END_OF_LIST		= '\r';
    byte	LIST_FILES			= 'L';
    byte	SEND_FILE			= 'F';
    byte	END				= '\n';
    byte	FILE_EXISTS		= 'Y';
    byte	FILE_DOES_NOT_EXIST	= 'N';
}
