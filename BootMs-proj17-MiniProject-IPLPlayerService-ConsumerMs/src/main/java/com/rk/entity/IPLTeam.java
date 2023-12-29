package com.rk.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MS_MP_IPLTEAM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class IPLTeam implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEAM_ID")
	private Integer teamId;
	@NonNull
	@Column(length = 20)
	private String teamName;
	@NonNull
	private Integer teamSize;
	@Column(length = 20)
	@NonNull
	private String teamOwner;
	@JsonManagedReference
	@OneToMany(targetEntity = IPLPlayer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_INFO_ID",referencedColumnName = "TEAM_ID")
	@NonNull
	private Set<IPLPlayer> players;

	//ToString
	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", teamName=" + teamName + ", teamSize=" + teamSize + ", teamOwner="
				+ teamOwner + "]";
	}
	
	
}
