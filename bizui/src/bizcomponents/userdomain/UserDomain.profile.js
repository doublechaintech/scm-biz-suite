

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UserDomain.profile.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf, defaultRenderSettingList,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf

const internalRenderSettingList = defaultRenderSettingList

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}

const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.UserDomainBase.renderItemOfList(item, targetComponents)

}



class UserDomainProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  userDomain = this.props.userDomain;
    const { id,displayName, userWhiteListCount, secUserCount } = userDomain
    const  returnURL = `/userDomain/${id}/dashboard`
    const cardsData = {cardsName:"用户域",cardsFor: "userDomain",cardsSource: userDomain,displayName,returnURL,
  		subItems: [
{name: 'userWhiteListList', displayName:'用户白名单',type:'userWhiteList',count:userWhiteListCount,addFunction: true, role: 'userWhiteList',  renderItem: GlobalComponents.UserWhiteListBase.renderItemOfList},
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList
    
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {renderSettingList(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  userDomain: state._userDomain,
}))(Form.create()(UserDomainProfile))

