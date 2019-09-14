import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './EmployeeSalarySheet.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import EmployeeSalarySheetBase from './EmployeeSalarySheet.base'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  baseSalary: '2353.12',
  bonus: '847.05',
  reward: '801.32',
  personalTax: '747.24',
  socialSecurity: '961.10',
  housingFound: '937.13',
  jobInsurance: '7.22',
  employeeId: 'E000001',
  currentSalaryGradeId: 'SG000001',
}
*/


const imageKeys = [
]


class EmployeeSalarySheetAssociateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
 
    
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {EmployeeSalarySheetService} = GlobalComponents
    const userContext = null
    


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = EmployeeSalarySheetBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
   
    return (
 <Modal
          title={appLocaleName(userContext,"CreateNew")}
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title={appLocaleName(userContext,"BasicInfo")}  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.baseSalary} {...formItemLayout}>
                  {getFieldDecorator('baseSalary', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="基本工资" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.bonus} {...formItemLayout}>
                  {getFieldDecorator('bonus', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="奖金" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.reward} {...formItemLayout}>
                  {getFieldDecorator('reward', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="奖励" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.personalTax} {...formItemLayout}>
                  {getFieldDecorator('personalTax', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="个人所得税" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.socialSecurity} {...formItemLayout}>
                  {getFieldDecorator('socialSecurity', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="社会保险" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.housingFound} {...formItemLayout}>
                  {getFieldDecorator('housingFound', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="住房公积金" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.jobInsurance} {...formItemLayout}>
                  {getFieldDecorator('jobInsurance', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="失业保险" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.employee} {...formItemLayout}>
                  {getFieldDecorator('employeeId', {
                  	initialValue: tryinit('employee'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('employee')}
                    targetType={"employee"} 
                    requestFunction={EmployeeSalarySheetService.requestCandidateEmployee}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.currentSalaryGrade} {...formItemLayout}>
                  {getFieldDecorator('currentSalaryGradeId', {
                  	initialValue: tryinit('currentSalaryGrade'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
                    requestFunction={EmployeeSalarySheetService.requestCandidateCurrentSalaryGrade}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(EmployeeSalarySheetAssociateForm))




