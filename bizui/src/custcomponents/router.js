

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {MoyiBizApp} = GlobalComponents
	const {MoyiPlatformConfigurationBizApp} = GlobalComponents
	const {RewardValueOptionBizApp} = GlobalComponents
	const {OperationPageBizApp} = GlobalComponents
	const {SurvivalStatusBizApp} = GlobalComponents
	const {SlideBizApp} = GlobalComponents
	const {SlideTypeBizApp} = GlobalComponents
	const {ChannelBizApp} = GlobalComponents
	const {ChannelTypeBizApp} = GlobalComponents
	const {ChannelSectionTypeBizApp} = GlobalComponents
	const {ChannelSectionBizApp} = GlobalComponents
	const {ChannelArticleBizApp} = GlobalComponents
	const {MasterColumnBizApp} = GlobalComponents
	const {SectionBizApp} = GlobalComponents
	const {SectionArtworkRelationshipBizApp} = GlobalComponents
	const {SectionFansBizApp} = GlobalComponents
	const {ModeratorBizApp} = GlobalComponents
	const {ModeratorPunishmentBizApp} = GlobalComponents
	const {ModeratorBonusBizApp} = GlobalComponents
	const {EliteArticleBizApp} = GlobalComponents
	const {SectionTopArticleBizApp} = GlobalComponents
	const {SectionBroadcastArticleBizApp} = GlobalComponents
	const {ArticleBonusBizApp} = GlobalComponents
	const {BonusTypeBizApp} = GlobalComponents
	const {ArtistBizApp} = GlobalComponents
	const {ArtistFansBizApp} = GlobalComponents
	const {MoyiUserBizApp} = GlobalComponents
	const {UserInviteCodeBizApp} = GlobalComponents
	const {UserInviteRegistrationInfoBizApp} = GlobalComponents
	const {OrganizationBizApp} = GlobalComponents
	const {OrganizationTypeBizApp} = GlobalComponents
	const {MoyiUserFansBizApp} = GlobalComponents
	const {MoyiUserCheckinRecordBizApp} = GlobalComponents
	const {TransactionDirectionBizApp} = GlobalComponents
	const {RewardDetailRecordBizApp} = GlobalComponents
	const {ArtworkBizApp} = GlobalComponents
	const {ArtworkImageBizApp} = GlobalComponents
	const {ArtworkLikeBizApp} = GlobalComponents
	const {ArtworkFansBizApp} = GlobalComponents
	const {ArtworkCertificateBizApp} = GlobalComponents
	const {ArtTypeBizApp} = GlobalComponents
	const {ArtworkTypeBizApp} = GlobalComponents
	const {ArtworkTypeImageBizApp} = GlobalComponents
	const {ArtworkMaterialBizApp} = GlobalComponents
	const {ArtworkStyleBizApp} = GlobalComponents
	const {ArtworkCategoryBizApp} = GlobalComponents
	const {ArtworkSkillBizApp} = GlobalComponents
	const {ArtworkTopicBizApp} = GlobalComponents
	const {ArtworkCountryBizApp} = GlobalComponents
	const {ArtworkFigureBizApp} = GlobalComponents
	const {ArtworkFontStyleBizApp} = GlobalComponents
	const {ArtworkDynastyBizApp} = GlobalComponents
	const {ArtworkKindBizApp} = GlobalComponents
	const {ArtworkDecadeBizApp} = GlobalComponents
	const {ArticleBizApp} = GlobalComponents
	const {EditorSuggestionBizApp} = GlobalComponents
	const {DisplayModeBizApp} = GlobalComponents
	const {ArticleTypeBizApp} = GlobalComponents
	const {ArticleImageBizApp} = GlobalComponents
	const {ArticleLikeBizApp} = GlobalComponents
	const {ContentTagBizApp} = GlobalComponents
	const {ReviewBizApp} = GlobalComponents
	const {ReviewLikeBizApp} = GlobalComponents
	const {SuperNodeUserBizApp} = GlobalComponents
	const {SuperPartnerUserBizApp} = GlobalComponents
	const {MoyiEditorUserBizApp} = GlobalComponents
	const {MoyiColumnAuthorBizApp} = GlobalComponents
	const {MoyiArtworkReviewAuthorBizApp} = GlobalComponents
	const {MoyiMasterOpinionAuthorBizApp} = GlobalComponents
	const {MoyiUserDailyInkValueBizApp} = GlobalComponents
	const {MoyiDailyTopUserBizApp} = GlobalComponents
	const {ArtworkDailyInkValueBizApp} = GlobalComponents
	const {MoyiDailyTopArtworkBizApp} = GlobalComponents
	const {SpamReportBizApp} = GlobalComponents
	const {SystemMessageBizApp} = GlobalComponents
	const {PrivateMessageBizApp} = GlobalComponents
	const {InkCoinIncentiveRuleBizApp} = GlobalComponents
	const {MoyiExperienceRuleBizApp} = GlobalComponents
	const {UserLevelBizApp} = GlobalComponents
	const {MoyiExperienceRecordBizApp} = GlobalComponents
	const {ConfirmationStatusBizApp} = GlobalComponents
	const {BlockingTypeBizApp} = GlobalComponents
	const {UserBlockingBizApp} = GlobalComponents
	const {ReviewBlockingBizApp} = GlobalComponents
	const {ArticleBlockingBizApp} = GlobalComponents
	const {ArtworkBlockingBizApp} = GlobalComponents
	const {ImportantOperationRecordBizApp} = GlobalComponents
	const {DeliverArtworkBizApp} = GlobalComponents
	const {DeliverArticleBizApp} = GlobalComponents
	const {TipArticleBizApp} = GlobalComponents
	const {TipArtworkBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
         <Route path="/home" component={Launcher} />
         <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/moyi/" component={MoyiBizApp} />
          <Route path="/moyiPlatformConfiguration/" component={MoyiPlatformConfigurationBizApp} />
          <Route path="/rewardValueOption/" component={RewardValueOptionBizApp} />
          <Route path="/operationPage/" component={OperationPageBizApp} />
          <Route path="/survivalStatus/" component={SurvivalStatusBizApp} />
          <Route path="/slide/" component={SlideBizApp} />
          <Route path="/slideType/" component={SlideTypeBizApp} />
          <Route path="/channel/" component={ChannelBizApp} />
          <Route path="/channelType/" component={ChannelTypeBizApp} />
          <Route path="/channelSectionType/" component={ChannelSectionTypeBizApp} />
          <Route path="/channelSection/" component={ChannelSectionBizApp} />
          <Route path="/channelArticle/" component={ChannelArticleBizApp} />
          <Route path="/masterColumn/" component={MasterColumnBizApp} />
          <Route path="/section/" component={SectionBizApp} />
          <Route path="/sectionArtworkRelationship/" component={SectionArtworkRelationshipBizApp} />
          <Route path="/sectionFans/" component={SectionFansBizApp} />
          <Route path="/moderator/" component={ModeratorBizApp} />
          <Route path="/moderatorPunishment/" component={ModeratorPunishmentBizApp} />
          <Route path="/moderatorBonus/" component={ModeratorBonusBizApp} />
          <Route path="/eliteArticle/" component={EliteArticleBizApp} />
          <Route path="/sectionTopArticle/" component={SectionTopArticleBizApp} />
          <Route path="/sectionBroadcastArticle/" component={SectionBroadcastArticleBizApp} />
          <Route path="/articleBonus/" component={ArticleBonusBizApp} />
          <Route path="/bonusType/" component={BonusTypeBizApp} />
          <Route path="/artist/" component={ArtistBizApp} />
          <Route path="/artistFans/" component={ArtistFansBizApp} />
          <Route path="/moyiUser/" component={MoyiUserBizApp} />
          <Route path="/userInviteCode/" component={UserInviteCodeBizApp} />
          <Route path="/userInviteRegistrationInfo/" component={UserInviteRegistrationInfoBizApp} />
          <Route path="/organization/" component={OrganizationBizApp} />
          <Route path="/organizationType/" component={OrganizationTypeBizApp} />
          <Route path="/moyiUserFans/" component={MoyiUserFansBizApp} />
          <Route path="/moyiUserCheckinRecord/" component={MoyiUserCheckinRecordBizApp} />
          <Route path="/transactionDirection/" component={TransactionDirectionBizApp} />
          <Route path="/rewardDetailRecord/" component={RewardDetailRecordBizApp} />
          <Route path="/artwork/" component={ArtworkBizApp} />
          <Route path="/artworkImage/" component={ArtworkImageBizApp} />
          <Route path="/artworkLike/" component={ArtworkLikeBizApp} />
          <Route path="/artworkFans/" component={ArtworkFansBizApp} />
          <Route path="/artworkCertificate/" component={ArtworkCertificateBizApp} />
          <Route path="/artType/" component={ArtTypeBizApp} />
          <Route path="/artworkType/" component={ArtworkTypeBizApp} />
          <Route path="/artworkTypeImage/" component={ArtworkTypeImageBizApp} />
          <Route path="/artworkMaterial/" component={ArtworkMaterialBizApp} />
          <Route path="/artworkStyle/" component={ArtworkStyleBizApp} />
          <Route path="/artworkCategory/" component={ArtworkCategoryBizApp} />
          <Route path="/artworkSkill/" component={ArtworkSkillBizApp} />
          <Route path="/artworkTopic/" component={ArtworkTopicBizApp} />
          <Route path="/artworkCountry/" component={ArtworkCountryBizApp} />
          <Route path="/artworkFigure/" component={ArtworkFigureBizApp} />
          <Route path="/artworkFontStyle/" component={ArtworkFontStyleBizApp} />
          <Route path="/artworkDynasty/" component={ArtworkDynastyBizApp} />
          <Route path="/artworkKind/" component={ArtworkKindBizApp} />
          <Route path="/artworkDecade/" component={ArtworkDecadeBizApp} />
          <Route path="/article/" component={ArticleBizApp} />
          <Route path="/editorSuggestion/" component={EditorSuggestionBizApp} />
          <Route path="/displayMode/" component={DisplayModeBizApp} />
          <Route path="/articleType/" component={ArticleTypeBizApp} />
          <Route path="/articleImage/" component={ArticleImageBizApp} />
          <Route path="/articleLike/" component={ArticleLikeBizApp} />
          <Route path="/contentTag/" component={ContentTagBizApp} />
          <Route path="/review/" component={ReviewBizApp} />
          <Route path="/reviewLike/" component={ReviewLikeBizApp} />
          <Route path="/superNodeUser/" component={SuperNodeUserBizApp} />
          <Route path="/superPartnerUser/" component={SuperPartnerUserBizApp} />
          <Route path="/moyiEditorUser/" component={MoyiEditorUserBizApp} />
          <Route path="/moyiColumnAuthor/" component={MoyiColumnAuthorBizApp} />
          <Route path="/moyiArtworkReviewAuthor/" component={MoyiArtworkReviewAuthorBizApp} />
          <Route path="/moyiMasterOpinionAuthor/" component={MoyiMasterOpinionAuthorBizApp} />
          <Route path="/moyiUserDailyInkValue/" component={MoyiUserDailyInkValueBizApp} />
          <Route path="/moyiDailyTopUser/" component={MoyiDailyTopUserBizApp} />
          <Route path="/artworkDailyInkValue/" component={ArtworkDailyInkValueBizApp} />
          <Route path="/moyiDailyTopArtwork/" component={MoyiDailyTopArtworkBizApp} />
          <Route path="/spamReport/" component={SpamReportBizApp} />
          <Route path="/systemMessage/" component={SystemMessageBizApp} />
          <Route path="/privateMessage/" component={PrivateMessageBizApp} />
          <Route path="/inkCoinIncentiveRule/" component={InkCoinIncentiveRuleBizApp} />
          <Route path="/moyiExperienceRule/" component={MoyiExperienceRuleBizApp} />
          <Route path="/userLevel/" component={UserLevelBizApp} />
          <Route path="/moyiExperienceRecord/" component={MoyiExperienceRecordBizApp} />
          <Route path="/confirmationStatus/" component={ConfirmationStatusBizApp} />
          <Route path="/blockingType/" component={BlockingTypeBizApp} />
          <Route path="/userBlocking/" component={UserBlockingBizApp} />
          <Route path="/reviewBlocking/" component={ReviewBlockingBizApp} />
          <Route path="/articleBlocking/" component={ArticleBlockingBizApp} />
          <Route path="/artworkBlocking/" component={ArtworkBlockingBizApp} />
          <Route path="/importantOperationRecord/" component={ImportantOperationRecordBizApp} />
          <Route path="/deliverArtwork/" component={DeliverArtworkBizApp} />
          <Route path="/deliverArticle/" component={DeliverArticleBizApp} />
          <Route path="/tipArticle/" component={TipArticleBizApp} />
          <Route path="/tipArtwork/" component={TipArtworkBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
         <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










