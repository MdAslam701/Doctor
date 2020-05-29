package com.capgemini.bookmydoctor.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dto.*;
import com.capgemini.bookmydoctor.exception.DoctorIdNotFoundException;
import com.capgemini.bookmydoctor.exception.PatientIdNotFoundException;

public class PatientDaoImpl implements PatientDao {

	static Logger log = LogManager.getLogger(PatientDaoImpl.class);
	FileReader filereader;
	Properties pro;

	// to view doctor info
	@Override
	public DoctorInfoDto viewDoctorInfoJDBC(String speciality) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DoctorInfoDto doctorInfoDto = new DoctorInfoDto();
		try {

			System.out.println("In jdbc");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = "select * from doctor_info where speciality = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, speciality);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				doctorInfoDto.setDoctorId(rs.getInt("doctorId"));
				doctorInfoDto.setDoctorName(rs.getString("doctorName"));
				doctorInfoDto.setSpeciaity(rs.getString("speciality"));
				doctorInfoDto.setLocation(rs.getString("location"));
				doctorInfoDto.setAddress(rs.getString("address"));
				doctorInfoDto.setVisitingFees(rs.getLong("visitingFees"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return doctorInfoDto;

	}

	// view appointment history
//	@Override
//	public AppointmentInfoDto viewAppointmentInfoJDBC(int patientId) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		AppointmentInfoDto appointmentInfoDto = new AppointmentInfoDto();
//		try {
//
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			FileInputStream input = new FileInputStream("Database.properties");
//			Properties pro = new Properties();
//			pro.load(input);
//			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
//			conn = DriverManager.getConnection(dburl, pro);
//			String query = " select * from appointment_info where patientId = ? ";
//			pstmt = conn.prepareStatement(query);
//			pstmt.setLong(1, patientId);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				appointmentInfoDto.setAppointmentId(rs.getInt("appointmentId"));
//				appointmentInfoDto.setPatientId(rs.getInt("patientId"));
//				appointmentInfoDto.setDoctorId(rs.getInt("doctorId"));
//				appointmentInfoDto.setDate(rs.getDate("date"));
//				appointmentInfoDto.setTime(rs.getTime("time"));
//				appointmentInfoDto.setStatus(rs.getString("status"));
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (rs != null) {
//					rs.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return appointmentInfoDto;
//
//	}
	
	
	
	
	
	
	public AppointmentInfoDto viewAppointmentInfoJDBC(int patientId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		AppointmentInfoDto appointmentInfo = null;

		try (FileInputStream file = new FileInputStream("Database.properties");) {
			Properties pro = new Properties();
			pro.load(file);
			try (Connection connection = DriverManager.getConnection(pro.getProperty("dburl"));
					PreparedStatement pstmt = connection.prepareStatement(pro.getProperty("viewappointmentquery"));) {

				pstmt.setInt(1, patientId);

				try (ResultSet rs = pstmt.executeQuery();) {
					while (rs.next()) {
						appointmentInfo = new AppointmentInfoDto();
						appointmentInfo.setAppointmentId(rs.getInt("appointmentId"));
						appointmentInfo.setPatientId(rs.getInt("patientId"));
						appointmentInfo.setDoctorId(rs.getInt("doctorId"));
						appointmentInfo.setDate(rs.getDate("date"));
						appointmentInfo.setTime(rs.getTime("time"));
						appointmentInfo.setStatus(rs.getString("status"));

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return appointmentInfo;

	}


	// patient history
	public PatientHistoryDto viewPatientHistoryJDBC(int patientId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PatientHistoryDto patientHistoryDto = new PatientHistoryDto();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = "select * from patient_history where patientId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, patientId);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				patientHistoryDto.setPatientId(rs.getInt("patientId"));
				patientHistoryDto.setDoctorId(rs.getInt("doctorId"));
				patientHistoryDto.setAppointmentId(rs.getInt("appointmentId"));
				patientHistoryDto.setTreatment(rs.getString("treatment"));
				patientHistoryDto.setPreviousAppointmentDate(rs.getDate("previousAppointmentDate"));
			}

		} catch (Exception e) {

			throw new PatientIdNotFoundException();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return patientHistoryDto;

	}

	// view feedback
	public List<FeedbackDetailsDto> viewFeedbackDetailsJDBC(FeedbackDetailsDto f) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FeedbackDetailsDto feedbackDetailsDto = new FeedbackDetailsDto();

		List<FeedbackDetailsDto> list = new ArrayList<FeedbackDetailsDto>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = "select * from feedback_deatails";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FeedbackDetailsDto feedbackDto1 = new FeedbackDetailsDto();
				feedbackDto1.setDoctorId(rs.getInt("doctorId"));
				feedbackDto1.setFeedbackId(rs.getInt("feedbackId"));
				feedbackDto1.setPatientId(rs.getInt("patientId"));
				feedbackDto1.setRating(rs.getString("rating"));

				list.add(feedbackDto1);

			}
			return list;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// to view available doctors
		@Override
		public DoctorAvailabilityDto viewDoctorAvailabilityJDBC(int doctorId) {
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			DoctorAvailabilityDto doctorAvailabilityDto = new DoctorAvailabilityDto();
			try {
	
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				FileInputStream input = new FileInputStream("Database.properties");
				Properties pro = new Properties();
				pro.load(input);
				String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
				conn = DriverManager.getConnection(dburl, pro);
				String query = " select * from doctor_availability where doctorId= ? ";
				pstmt = conn.prepareStatement(query);
				pstmt.setLong(1, doctorId);
				rs = pstmt.executeQuery();
	
				while (rs.next()) {
	
					doctorAvailabilityDto.setDoctorId(rs.getInt("doctorId"));
					doctorAvailabilityDto.setFromTime(rs.getTime("fromTime"));
					doctorAvailabilityDto.setToTime(rs.getTime("toTime"));
					doctorAvailabilityDto.setFromDate(rs.getDate("fromDate"));
					doctorAvailabilityDto.setToDate(rs.getDate("toDate"));
					doctorAvailabilityDto.setIsAvailable(rs.getString("isAvailable"));
	
				}
	
			} catch (Exception e) {
	
				throw new DoctorIdNotFoundException();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return doctorAvailabilityDto;
	
		}

//	public DoctorAvailabilityDto viewDoctorAvailabilityJDBC(int doctorId) {
//
//		DoctorAvailabilityDto doctorAvailabilityDto = new DoctorAvailabilityDto();
//		try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro.getProperty("user"),
//				pro.getProperty("password"));
//				PreparedStatement pstmt = conn.prepareStatement(pro.getProperty("DoctorAvailability"))){
//			pstmt.setInt(1, doctorId);
//			ResultSet rs =pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				doctorAvailabilityDto.setDoctorId(rs.getInt("doctorId"));
//				doctorAvailabilityDto.setFromTime(rs.getTime("fromTime"));
//				doctorAvailabilityDto.setToTime(rs.getTime("toTime"));
//				doctorAvailabilityDto.setFromDate(rs.getDate("fromDate"));
//				doctorAvailabilityDto.setToDate(rs.getDate("toDate"));
//				doctorAvailabilityDto.setIsAvailable(rs.getString("isAvailable"));
//
//
//			}
//		}catch (Exception e) {
//			throw new DoctorIdNotFoundException();
//
//		}
//		return doctorAvailabilityDto;
//		
//
//
//
//
//	}



	// give feedback
	@Override
	public void writeReviewJDBC(FeedbackDetailsDto detailsDto) {
		System.out.println("write a review");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = " insert into feedback_deatails (patientId, doctorId, rating) values (?, ?, ?) ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, detailsDto.getPatientId());
			pstmt.setInt(2, detailsDto.getDoctorId());
			pstmt.setString(3, detailsDto.getRating());

			pstmt.executeUpdate();

			System.out.println("feedback given");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// book appointment
	@Override
	public void bookAppointmentJDBC(AppointmentInfoDto infoDto) {

		System.out.println("book an appointment");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = " insert into appointment_info (patientId, doctorId, date, time, status) values (?, ?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, infoDto.getPatientId());
			pstmt.setInt(2, infoDto.getDoctorId());
			pstmt.setDate(3, infoDto.getDate());
			pstmt.setTime(4, infoDto.getTime());
			pstmt.setString(5, "pending");

			pstmt.executeUpdate();

			System.out.println("feedback given");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addPatientInfoJDBC(PatientInfoDto patientInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);

			String query = "insert into patient_info (patientId, patientName, disease, secPhoneNo) values(?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, patientInfo.getPatientId());
			pstmt.setString(2, patientInfo.getPatientName());
			pstmt.setString(3, patientInfo.getDisease());
			pstmt.setLong(4, patientInfo.getSecPhoneNo());

			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
}