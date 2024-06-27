package com.RS.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.RS.entity.automationTasks.Airtable;
import com.RS.entity.automationTasks.Asana;
import com.RS.entity.automationTasks.Basecamp;
import com.RS.entity.automationTasks.Bitbucket;
import com.RS.entity.automationTasks.Box;
import com.RS.entity.automationTasks.Calendar;
import com.RS.entity.automationTasks.ClickUp;
import com.RS.entity.automationTasks.Connections;
import com.RS.entity.automationTasks.DiscordWebhook;
import com.RS.entity.automationTasks.Dropbox;
import com.RS.entity.automationTasks.Freshdesk;
import com.RS.entity.automationTasks.GitHub;
import com.RS.entity.automationTasks.GitLab;
import com.RS.entity.automationTasks.GoogleAds;
import com.RS.entity.automationTasks.GoogleAnalytics;
import com.RS.entity.automationTasks.GoogleCalendar;
import com.RS.entity.automationTasks.GoogleDrive;
import com.RS.entity.automationTasks.GoogleForms;
import com.RS.entity.automationTasks.GoogleSheets;
import com.RS.entity.automationTasks.HubSpot;
import com.RS.entity.automationTasks.Intercom;
import com.RS.entity.automationTasks.Jira;
import com.RS.entity.automationTasks.LocalGoogleCredential;
import com.RS.entity.automationTasks.Mailchimp;
import com.RS.entity.automationTasks.Mailgun;
import com.RS.entity.automationTasks.MicrosoftOutlook;
import com.RS.entity.automationTasks.MicrosoftTeams;
import com.RS.entity.automationTasks.Monday;
import com.RS.entity.automationTasks.Notion;
import com.RS.entity.automationTasks.OneDrive;
import com.RS.entity.automationTasks.PayPal;
import com.RS.entity.automationTasks.QuickBooks;
import com.RS.entity.automationTasks.Salesforce;
import com.RS.entity.automationTasks.Shopify;
import com.RS.entity.automationTasks.Slack;
import com.RS.entity.automationTasks.Smartsheet;
import com.RS.entity.automationTasks.Stripe;
import com.RS.entity.automationTasks.Todolist;
import com.RS.entity.automationTasks.Trello;
import com.RS.entity.automationTasks.Twilio;
import com.RS.entity.automationTasks.Workflows;
import com.RS.entity.automationTasks.Wrike;
import com.RS.entity.automationTasks.Zendesk;
import com.RS.entity.automationTasks.Zoom;
import com.RS.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank
    private String name;

    private String avatarUrl; // Use @Lob annotation for large texts

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private Role role = Role.SUBACCOUNT_USER;

    @NotBlank
    private String agency_Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agency_id", referencedColumnName = "id",insertable = false, updatable = false)
    private Agency agency;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Permissions> permissions;

    @OneToMany(mappedBy = "assigned", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ActivityTracker> activityTrackers;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todolist> todolists;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Airtable> airtable;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Asana> asana;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Basecamp> basecamp;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bitbucket> bitbucket;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Box> box;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Calendar> calendar;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ClickUp> clickUp;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DiscordWebhook> discordWebhook;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Dropbox> dropbox;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Freshdesk> freshDesk;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GitHub> github;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GitLab> gitlab;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoogleAds> googleAds;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoogleAnalytics> googleAnalytics;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoogleCalendar> googleCalendar;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoogleDrive> googleDrive;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoogleForms> googleForms;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoogleSheets> googleSheets;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HubSpot> hubSpot;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Intercom> intercom;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Jira> jira;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LocalGoogleCredential> localGoogleCredential;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mailchimp> mailchimp;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mailgun> mailgun;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MicrosoftOutlook> microsoftOutlook;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MicrosoftTeams> microsoftTeams;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Monday> monday;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notion> notion;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OneDrive> oneDrive;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PayPal> payPal;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QuickBooks> quickBooks;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Salesforce> salesforce;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Shopify> shopify;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Slack> slack;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Smartsheet> smartsheet;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Stripe> stripe;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Trello> trello;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Twilio> twilio;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wrike> wrike;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Workflows> workflows;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Zendesk> zendesk;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Zoom> zoom;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Connections> connections;

    // Other fields and relationships
}
