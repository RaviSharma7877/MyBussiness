package com.RS.entity.automationTasks;

import com.RS.entity.Users;
import com.RS.entity.automationTasks.Bot.DiscordBot;
import com.RS.entity.automationTasks.Bot.GitHubBot;
import com.RS.entity.automationTasks.Bot.JiraBot;
import com.RS.entity.automationTasks.Bot.MicrosoftTeamsBot;
import com.RS.entity.automationTasks.Bot.NotionBot;
import com.RS.entity.automationTasks.Bot.SlackBot;
import com.RS.entity.automationTasks.Bot.TrelloBot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Connections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "airtableId", referencedColumnName = "id", insertable = false, updatable = false)
    private Airtable airtable;

    @ManyToOne
    @JoinColumn(name = "discordWebhookId", referencedColumnName = "id", insertable = false, updatable = false)
    private DiscordWebhook discordWebhook;
    private String discordWebhookId;

    @ManyToOne
    @JoinColumn(name = "notionId", referencedColumnName = "id", insertable = false, updatable = false)
    private Notion notion;
    private String notionId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;
    private String userId;

    @ManyToOne
    @JoinColumn(name = "slackId", referencedColumnName = "id", insertable = false, updatable = false)
    private Slack slack;
    private String slackId;

    @OneToOne
    @JoinColumn(name = "localGoogleCredentialId", referencedColumnName = "id", insertable = false, updatable = false)
    private LocalGoogleCredential localGoogleCredential;
    private String localGoogleCredentialId;

    @ManyToOne
    @JoinColumn(name = "bitbucketId", referencedColumnName = "id", insertable = false, updatable = false)
    private Bitbucket bitbucket;
    private String bitbucketId;

    @ManyToOne
    @JoinColumn(name = "googleCalendarId", referencedColumnName = "id", insertable = false, updatable = false)
    private GoogleCalendar googleCalendar;
    private String googleCalendarId;

    @ManyToOne
    @JoinColumn(name = "oneDriveId", referencedColumnName = "id", insertable = false, updatable = false)
    private OneDrive oneDrive;
    private String oneDriveId;

    @ManyToOne
    @JoinColumn(name = "mondayId", referencedColumnName = "id", insertable = false, updatable = false)
    private Monday monday;
    private String mondayId;

    @ManyToOne
    @JoinColumn(name = "clickUpId", referencedColumnName = "id", insertable = false, updatable = false)
    private ClickUp clickUp;
    private String clickUpId;

    @ManyToOne
    @JoinColumn(name = "todolist_Id", referencedColumnName = "id", insertable = false, updatable = false)
    private Todolist todolist;
    private String todoistId;

    @ManyToOne
    @JoinColumn(name = "basecampId", referencedColumnName = "id", insertable = false, updatable = false)
    private Basecamp basecamp;
    private String basecampId;

    @ManyToOne
    @JoinColumn(name = "wrikeId", referencedColumnName = "id", insertable = false, updatable = false)
    private Wrike wrike;
    private String wrikeId;

    @ManyToOne
    @JoinColumn(name = "smartsheetId", referencedColumnName = "id", insertable = false, updatable = false)
    private Smartsheet smartsheet;
    private String smartsheetId;

    @ManyToOne
    @JoinColumn(name = "boxId", referencedColumnName = "id", insertable = false, updatable = false)
    private Box box;
    private String boxId;

    @ManyToOne
    @JoinColumn(name = "freshdeskId", referencedColumnName = "id", insertable = false, updatable = false)
    private Freshdesk freshdesk;
    private String freshdeskId;

    @ManyToOne
    @JoinColumn(name = "zoomId", referencedColumnName = "id", insertable = false, updatable = false)
    private Zoom zoom;
    private String zoomId;

    @ManyToOne
    @JoinColumn(name = "slackBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private SlackBot slackBot;
    private String slackBotId;

    @ManyToOne
    @JoinColumn(name = "discordBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private DiscordBot discordBot;
    private String discordBotId;

    @ManyToOne
    @JoinColumn(name = "microsoftTeamsBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private MicrosoftTeamsBot microsoftTeamsBot;
    private String microsoftTeamsBotId;

    @ManyToOne
    @JoinColumn(name = "gitHubBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private GitHubBot gitHubBot;
    private String gitHubBotId;

    @ManyToOne
    @JoinColumn(name = "jiraBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private JiraBot jiraBot;
    private String jiraBotId;

    @ManyToOne
    @JoinColumn(name = "notionBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private NotionBot notionBot;
    private String notionBotId;

    @ManyToOne
    @JoinColumn(name = "trelloBotId", referencedColumnName = "id", insertable = false, updatable = false)
    private TrelloBot trelloBot;
    private String trelloBotId;

    @ManyToOne
    @JoinColumn(name = "googleSheetsId", referencedColumnName = "id", insertable = false, updatable = false)
    private GoogleSheets googleSheets;
    private String googleSheetsId;

    @ManyToOne
    @JoinColumn(name = "microsoftOutlookId", referencedColumnName = "id", insertable = false, updatable = false)
    private MicrosoftOutlook microsoftOutlook;
    private String microsoftOutlookId;

    @ManyToOne
    @JoinColumn(name = "twilioId", referencedColumnName = "id", insertable = false, updatable = false)
    private Twilio twilio;
    private String twilioId;

    @ManyToOne
    @JoinColumn(name = "intercomId", referencedColumnName = "id", insertable = false, updatable = false)
    private Intercom intercom;
    private String intercomId;

    @ManyToOne
    @JoinColumn(name = "googleFormsId", referencedColumnName = "id", insertable = false, updatable = false)
    private GoogleForms googleForms;
    private String googleFormsId;

    @ManyToOne
    @JoinColumn(name = "googleAnalyticsId", referencedColumnName = "id", insertable = false, updatable = false)
    private GoogleAnalytics googleAnalytics;
    private String googleAnalyticsId;

    @ManyToOne
    @JoinColumn(name = "googleAdsId", referencedColumnName = "id", insertable = false, updatable = false)
    private GoogleAds googleAds;
    private String googleAdsId;

    @ManyToOne
    @JoinColumn(name = "shopifyId", referencedColumnName = "id", insertable = false, updatable = false)
    private Shopify shopify;
    private String shopifyId;

    @ManyToOne
    @JoinColumn(name = "stripeId", referencedColumnName = "id", insertable = false, updatable = false)
    private Stripe stripe;
    private String stripeId;

    @ManyToOne
    @JoinColumn(name = "payPalId", referencedColumnName = "id", insertable = false, updatable = false)
    private PayPal payPal;
    private String payPalId;

    @ManyToOne
    @JoinColumn(name = "mailgunId", referencedColumnName = "id", insertable = false, updatable = false)
    private Mailgun mailgun;
    private String mailgunId;

    @ManyToOne
    @JoinColumn(name = "asanaId", referencedColumnName = "id", insertable = false, updatable = false)
    private Asana asana;
    private String asanaId;

    @ManyToOne
    @JoinColumn(name = "trelloId", referencedColumnName = "id", insertable = false, updatable = false)
    private Trello trello;
    private String trelloId;

    @ManyToOne
    @JoinColumn(name = "gitLabId", referencedColumnName = "id", insertable = false, updatable = false)
    private GitLab gitLab;
    private String gitLabId;

    @ManyToOne
    @JoinColumn(name = "calendarId", referencedColumnName = "id", insertable = false, updatable = false)
    private Calendar calendar;
    private String calenderId;

    @ManyToOne
    @JoinColumn(name = "dropboxId", referencedColumnName = "id", insertable = false, updatable = false)
    private Dropbox dropbox;
    private String dropboxId;

    @ManyToOne
    @JoinColumn(name = "githubId", referencedColumnName = "id", insertable = false, updatable = false)
    private GitHub github;
    private String githubId;

    @ManyToOne
    @JoinColumn(name = "googleDriveId", referencedColumnName = "id", insertable = false, updatable = false)
    private GoogleDrive googleDrive;
    private String googleDriveId;

    @ManyToOne
    @JoinColumn(name = "hubSpotId", referencedColumnName = "id", insertable = false, updatable = false)
    private HubSpot hubSpot;
    private String hubSpotId;

    @ManyToOne
    @JoinColumn(name = "jiraId", referencedColumnName = "id", insertable = false, updatable = false)
    private Jira jira;
    private String jiraId;

    @ManyToOne
    @JoinColumn(name = "mailchimpId", referencedColumnName = "id", insertable = false, updatable = false)
    private Mailchimp mailchimp;
    private String mailchimpId;

    @ManyToOne
    @JoinColumn(name = "microsoftTeamsId", referencedColumnName = "id", insertable = false, updatable = false)
    private MicrosoftTeams microsoftTeams;
    private String microsoftTeamsId;

    @ManyToOne
    @JoinColumn(name = "quickBooksId", referencedColumnName = "id", insertable = false, updatable = false)
    private QuickBooks quickBooks;
    private String quickBooksId;

    @ManyToOne
    @JoinColumn(name = "salesforceId", referencedColumnName = "id", insertable = false, updatable = false)
    private Salesforce salesforce;
    private String salesforceId;

    @ManyToOne
    @JoinColumn(name = "zendeskId", referencedColumnName = "id", insertable = false, updatable = false)
    private Zendesk zendesk;
    private String zendeskId;

    // Getters and Setters for all fields
    // ...
}
