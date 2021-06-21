package com.devjaws.instagramclone.utils.security;

import kr.co.kbz.domains.user.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class SecurityUtil {
	private final static Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

	public static String getShortUUID() {
		return makeShortUUID(getUUID());
	}

	private static UUID getUUID() {
		return UUID.randomUUID();
	}

	public static UserDTO getCurrentUser() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		return ((UserDTO) auth.getPrincipal());
	}

	public static String sha256Encrypt(String str) {
		try {
			var sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			var digestBytes = sh.digest();
			var builder = new StringBuilder();

			for (var digestByte : digestBytes)
				builder.append(Integer.toString((digestByte & 0xff) + 0x100, 16).substring(1));

			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String makeShortUUID(UUID uuid) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16);
		byteBuffer.putLong(uuid.getMostSignificantBits());
		byteBuffer.putLong(uuid.getLeastSignificantBits());

		// / 와 + 는 URL 및 파일 이름 사용 시 의도치 않은 현상이 일어날 수 있어서 _, - 로 변경
		return Base64.getEncoder().withoutPadding().encodeToString(byteBuffer.array())
				.replaceAll("/", "_")
				.replaceAll("\\+", "-");
	}
}
