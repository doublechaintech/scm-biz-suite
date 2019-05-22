

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './PotentialCustomerContactPerson.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (potentialCustomerContactPerson,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{potentialCustomerContactPerson.id}</Description> 
<Description term="名称">{potentialCustomerContactPerson.name}</Description> 
<Description term="手机">{potentialCustomerContactPerson.mobile}</Description> 
<Description term="描述">{potentialCustomerContactPerson.description}</Description> 
	
      </DescriptionList>
	)
}



class PotentialCustomerContactPersonProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  potentialCustomerContactPerson = this.props.potentialCustomerContactPerson;
    const { id,displayName, potentialCustomerContactCount } = potentialCustomerContactPerson

    const cardsData = {cardsName:"潜在客户联络人",cardsFor: "potentialCustomerContactPerson",cardsSource: potentialCustomerContactPerson,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  potentialCustomerContactPerson: state._potentialCustomerContactPerson,
}))(Form.create()(PotentialCustomerContactPersonProfile))

